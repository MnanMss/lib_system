package com.demp.service;

import com.demp.model.Customer;
import com.demp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements UserService<Customer>{

    CustomerRepository customerRepo;

    @Autowired
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer loadUser(String username) {
        return customerRepo.findByUsername(username);
    }

    @Override
    public void deleteById(long l) {
        customerRepo.deleteById(l);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepo.findById(id);
    }

    public Customer saveUser(Customer user) {
        return customerRepo.save(user);
    }
}
