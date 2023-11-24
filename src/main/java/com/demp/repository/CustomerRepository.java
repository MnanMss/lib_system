package com.demp.repository;

import com.demp.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer , Long> {

    Customer findByUsername(String username);
}
