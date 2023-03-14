package com.example.praktika.service;

import com.example.praktika.entity.AdminEntity;

import java.util.List;

public interface IAdminService {

    boolean addNewAdmin(String role, String username, String password);

    boolean saveAdmin(AdminEntity admin);

    List<AdminEntity> findAllAdmins();

    AdminEntity findById(int id);

    void delete(Integer id);
}
