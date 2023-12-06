package com.demp.controller;

import com.demp.model.Book;
import com.demp.model.Customer;
import com.demp.model.LendRecord;
import com.demp.service.BookService;
import com.demp.service.LendRecordService;
import com.demp.util.Result;
import com.demp.util.Upload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(path = "api/book", produces = "application/json")
@Slf4j
public class BookController {

    BookService service;
    LendRecordService lendService;

    @Autowired
    public BookController(BookService service, LendRecordService lendService) {
        this.service = service;
        this.lendService = lendService;
    }

    @PostMapping(path = "/add")
    public Result<?> addBook(@RequestParam("isbn") String ISBN,
                             @RequestParam("image") MultipartFile image,
                             @RequestParam("bookName") String bookName,
                             @RequestParam("description") String description,
                             @RequestParam("author") String author,
                             @RequestParam("bookCompany") String bookCompany,
                             @RequestParam("price") Double price,
                             @RequestParam("publishDate") String publishDate,
                             @RequestParam("totalNumber") int totalNumber) throws IOException {
        String msg = Upload.uploadFile(image, bookName);
        if (!msg.equals(Upload.successMsg)) {
            return Result.error("-1", msg);
        }
        String path = Upload.getBaseUrl();
        Book book = new Book(ISBN, bookName, description, author, bookCompany, price, publishDate, totalNumber);
        book.setFreeNumber(totalNumber);
        book.setImgSrc(path + "/" + bookName + Upload.imageType);
        service.save(book);
        return Result.success();
    }



    @PutMapping("/ModifyBook")
    public Result<?> modifyBook(@RequestParam("isbn") String ISBN,
                                @RequestParam("image") MultipartFile image,
                                @RequestParam("bookName") String bookName,
                                @RequestParam("description") String description,
                                @RequestParam("author") String author,
                                @RequestParam("bookCompany") String bookCompany,
                                @RequestParam("price") Double price,
                                @RequestParam("publishDate") String publishDate,
                                @RequestParam("id") UUID id,
                                @RequestParam("freeNumber") int freeNumber,
                                @RequestParam("totalNumber") int totalNumber){
        String msg = Upload.uploadFile(image, bookName);
        if(!msg.equals(Upload.successMsg)) {
            log.error(msg);
        }
        String path = Upload.getBaseUrl();
        Book book = new Book(ISBN, bookName, description, author, bookCompany, price, publishDate, totalNumber);
        book.setId(id);
        book.setImgSrc(path + "/" + bookName + Upload.imageType);
        book.setFreeNumber(freeNumber);
        service.save(book);
        return Result.success();
    }


    @PostMapping("/findALl")
    public Result<?> findAll() {
        Iterable<Book> list = service.findAll();
        return Result.success(list);
    }


    /**
     * @param lendRecord
     * @return
     */
    @PostMapping("/lend")
    public Result<?> lend(@RequestBody LendRecord lendRecord) {
        if(lendRecord.getCustomer().getLendBookNum() == 0) return Result.error("-1" , "达到借书上限");
        LendRecord saved = lendService.save(lendRecord);
        return Result.success(saved);
    }

    /**
     * 根据用户获取借书记录
     *
     * @param customer
     * @return
     */
    @PostMapping("/record")
    public Result<?> record(@RequestBody Customer customer) {
        Iterable<LendRecord> lendRecords = lendService.findByCustomer(customer);
        return Result.success(lendRecords);
    }

    @PostMapping("/deleteRecord")
    public Result<?> deleteRecord(@RequestBody LendRecord record) {
        lendService.deleteRecord(record);
        return Result.success();
    }

    @PostMapping("/returnBook")
    public Result<?> returnBook(@RequestBody LendRecord record) {
        LendRecord lendRecord = lendService.returnBook(record);
        return Result.success(lendRecord);
    }

    @PutMapping("/renewBook")
    public Result<?> renewBook(@RequestBody LendRecord record ) {
        if(record.getRenewTime() == 0) return Result.error("-1" , "续借次数达到上限");
        // lenDays增加
        LendRecord newRecord = lendService.renewBook(record);
        return Result.success(newRecord);
    }

    @DeleteMapping("/deleteBook/{id}")
    public Result<?> deleteBook(@PathVariable("id") UUID id) {
        service.deleteBookById(id);
        return Result.success();
    }

    @PostMapping("/findBookByName/{bookName}")
    public Result<?> findBookByName(@PathVariable("bookName") String bookName) {
        Book book = service.findBookByBookName(bookName);
        if(book == null) return Result.error("-1" , bookName + "不存在");
        return Result.success(book);
    }
}
