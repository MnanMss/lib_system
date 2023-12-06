package com.demp.controller;

import com.demp.model.Customer;
import com.demp.service.CustomerService;
import com.demp.service.LendRecordService;
import com.demp.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping(path = "api/Customer" , produces = "application/json")
public class CustomerController {

    CustomerService service;

    LendRecordService lendRecordService;

    @Autowired
    public CustomerController(CustomerService service , LendRecordService lendRecordService) {

        this.service = service;
        this.lendRecordService = lendRecordService;
    }

    @PostMapping("/login")
    public Result<?> login(@RequestBody Customer customer) {
        Customer user = service.loadUser(customer.getUsername());
        if(user == null) {
            return Result.error("-1" , "用户名不存在");
        }
        if(!Objects.equals(user.getPassword(), customer.getPassword())) {
            return Result.error("-1" , "密码错误");
        }

        // 检查是否有未还并且逾期
        if(lendRecordService.checkRecord(user)) {
            user.setLock(true);
        }
        return new Result<>("0" , "登录成功" , user);
    }

    @PostMapping("/register")
    public Result<?> register(@RequestBody Customer customer) {
        Customer user = service.saveUser(customer);
        if(user == null) {
            return Result.error("-1" , "注册失败");
        }
        return new Result<>("0" , "注册成功" , user);
    }

    @PutMapping("/modify")
    public Result<?> modify(@RequestBody Customer customer) {
        Customer user = service.saveUser(customer);
        return Result.success();
    }

}
