package com.demp.service;

import com.demp.model.Book;
import com.demp.model.Customer;
import com.demp.model.LendRecord;
import com.demp.repository.LendRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

@Service
@ConfigurationProperties(prefix = "lend")
public class LendRecordService {
    private final LendRecordRepository repo;

    private int renewDays = 15;

    private int maxLendDays = 31;

    private final CustomerService customerService;

    private final BookService bookService;

    @Autowired
    public LendRecordService(LendRecordRepository repo ,CustomerService customerService,BookService bookService) {
        this.repo = repo;
        this.bookService = bookService;
        this.customerService = customerService;
    }

    public void setRenewDays(int renewDays) {
        this.renewDays = renewDays;
    }

    public void setMaxLendDays(int maxLendDays) {
        this.maxLendDays = maxLendDays;
    }

    /**
     * 用户可借书数量-1
     * 书籍可借数量-1
     * 用户未还书籍+1
     * @param lendRecord
     * @return
     */
    @Transactional
    public LendRecord save(LendRecord lendRecord) {
        Book book = lendRecord.getBook();
        Customer customer = lendRecord.getCustomer();
        book.setFreeNumber(book.getFreeNumber() - 1);
        customer.setLendBookNum(customer.getLendBookNum() - 1);
        customer.setUnReturnedNum(customer.getUnReturnedNum() + 1);
        bookService.save(book);
        customerService.saveUser(customer);
        lendRecord.setLenDays(Math.min(lendRecord.getLenDays() , maxLendDays));
        return repo.save(lendRecord);
    }


    public Iterable<LendRecord> findByCustomer(Customer Customer) {
       return repo.findByCustomer(Customer);
    }


    public void deleteRecord(LendRecord record) {
        repo.delete(record);
    }

    /**
     * 用户可借书数量 +1
     * 书籍可借数量 +1
     * 用户未还书籍 -1
     * @param record
     * @return
     */
    @Transactional
    public LendRecord returnBook(LendRecord record) {
        Book book = record.getBook();
        Customer customer = record.getCustomer();
        book.setFreeNumber(book.getFreeNumber() + 1);
        customer.setLendBookNum(customer.getLendBookNum() + 1);
        customer.setUnReturnedNum(customer.getUnReturnedNum() - 1);
        bookService.save(book);
        customerService.saveUser(customer);
        record.setBook(book);
        record.setCustomer(customer);
        return repo.save(record);
    }

    public LendRecord renewBook(LendRecord record) {
        int temp = record.getLenDays();
        int between = record.getLenDays() - record.getResDays();
        int tempDays = record.getResDays() + renewDays;
        record.setLenDays(Math.min(tempDays, maxLendDays) + between - 1);
        record.setRenewTime(record.getRenewTime() - 1);
        if(temp == record.getLenDays()) return record;
        return repo.save(record);
    }

    public boolean checkRecord(Customer customer) {
        Iterable<LendRecord> lendRecords =  repo.findLendRecordsByCustomerAndReturnTimeIsNull(customer);
        if(!lendRecords.iterator().hasNext()) return false;
        ArrayList<LendRecord> records = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        // 判断是否有逾期记录
        for(LendRecord re : lendRecords) {
            LocalDate borrowTime = LocalDate.parse(re.getBorrowTime());
            long days = ChronoUnit.DAYS.between(borrowTime , currentDate);
            if(days > re.getLenDays()) return true; // 有逾期
        }
        return false;
    }

}
