package com.demp.service;

import com.demp.model.Admin;
import com.demp.repository.AdminRepository;
import org.springframework.stereotype.Service;


@Service
public class AdminService implements UserService<Admin>{
    AdminRepository adminRepo;

    public AdminService(AdminRepository adminRepo) {
        this.adminRepo = adminRepo;
    }
    @Override
    public Admin loadUser(String username) {
        return adminRepo.findByUsername(username);
    }


    @Override
    public Admin saveUser(Admin user) {
        return adminRepo.save(user);
    }

}
