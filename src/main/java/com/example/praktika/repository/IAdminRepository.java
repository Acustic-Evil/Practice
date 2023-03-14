package com.example.praktika.repository;

import com.example.praktika.entity.AdminEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdminRepository {

    AdminEntity findByUsername(String username);

    AdminEntity findById(int id);

    List<AdminEntity> findAllAdmins();

    void save(AdminEntity admin);
    void update(AdminEntity admin);
    void delete(Integer id);
}
