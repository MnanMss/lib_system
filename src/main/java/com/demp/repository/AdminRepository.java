package com.demp.repository;

import com.demp.model.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AdminRepository extends CrudRepository<Admin, UUID> {

    Admin findByUsername(String username);
}
