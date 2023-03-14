package com.example.praktika.repository;

import com.example.praktika.entity.AdminEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository {

    AdminEntity findByUsername(String username);

    List<AdminEntity> findAllAdmins();

    void save(AdminEntity admin);
    void update(AdminEntity admin);
    void delete(int id);
}
