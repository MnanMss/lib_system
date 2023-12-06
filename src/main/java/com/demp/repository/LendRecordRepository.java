package com.demp.repository;

import com.demp.model.Customer;
import com.demp.model.LendRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LendRecordRepository extends CrudRepository<LendRecord , UUID> {

    Iterable<LendRecord> findByCustomer(Customer customer);

    Iterable<LendRecord> findLendRecordsByCustomerAndReturnTimeIsNull(Customer customer);
}
