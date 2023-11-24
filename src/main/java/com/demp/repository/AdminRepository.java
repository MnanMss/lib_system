package com.demp.repository;

import com.demp.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {

    Admin findByUsername(String username);
}
