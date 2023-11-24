package com.demp.controller;

import com.demp.model.Customer;
import com.demp.service.CustomerService;
import com.demp.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/Customer")
public class CustomerController {

    CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public Result<?> login(@RequestBody Customer customer) {
        Customer user = service.loadUser(customer.getUsername());
        if(user == null) {
            return Result.error("-1" , "用户名不存在");
        }
        if(!Objects.equals(user.getPassword(), customer.getPassword())) {
            return Result.error("-1" , "密码错误");
        }
        return new Result<>(user);
    }

    @PostMapping
    public Result<?> register(@RequestBody Customer customer) {
        Customer user = service.saveUser(customer);
        if(user == null) {
            return Result.error("-1" , "用户存储失败");
        }
        return new Result<>("0" , "成功" , user);
    }

    @GetMapping("/{id}")
    public Result<?> findById(@PathVariable String id) {
        Optional<Customer> user = service.findById(Long.parseLong(id));
        if(user.isPresent()) return new Result<>("0" , "成功" , user.get());
        return Result.error("-1" , "用户id不存在");
    }


    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable String id) {
        service.deleteById(Long.parseLong(id));
        return Result.success();
    }
}
