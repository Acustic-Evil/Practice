package com.example.praktika.repository;

import com.example.praktika.entity.AdminEntity;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@Repository
public class AdminRepository implements IAdminRepository {
    private final String FILE_PATH = "src/main/data.json";
    ObjectMapper objectMapper = new ObjectMapper();
    private final AtomicInteger lastId = new AtomicInteger(1);
    public int generateId() {
        return lastId.incrementAndGet();
    }

    public AdminRepository() throws JsonProcessingException{
    }

    public Integer findLastId() throws JsonProcessingException {

        List<AdminEntity> existingAdmin = objectMapper.readValue(FILE_PATH, new TypeReference<List<AdminEntity>>() {}).stream().toList();
/*        int lastId = 0;
        for (AdminEntity admin : existingAdmin) {
            if (admin.getId() > lastId) {
                lastId = admin.getId();

            }
        }
        return lastId + 1;*/
        int i = 0;
        return existingAdmin.get(existingAdmin.size() - 1).getId();
    }


    @Override
    public AdminEntity findByUsername(String username) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<AdminEntity> admins = objectMapper.readValue(new File(FILE_PATH), new TypeReference<>() {});
            return admins.stream().filter(a -> a.getUsername().equals(username)).findFirst().orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AdminEntity> findAllAdmins() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(FILE_PATH), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(AdminEntity admin) {
        try {
            List<AdminEntity> admins = objectMapper.readValue(new File(FILE_PATH), new TypeReference<>() {});
            if (admin.getId() == null) {
                admin.setId(generateId());
            }
            admins.add(admin);
            objectMapper.writeValue(new File(FILE_PATH), admins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(AdminEntity admin) {
        List<AdminEntity> admins = findAllAdmins();
        for (int i = 0; i < admins.size(); i++) {
            if (Objects.equals(admins.get(i).getId(), admin.getId())) {
                admins.set(i, admin);
                break;
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(FILE_PATH), admins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        List<AdminEntity> persons = findAllAdmins();
        persons.removeIf(person -> Objects.equals(person.getId(), id));
        try {
            objectMapper.writeValue(new File(FILE_PATH), persons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AdminEntity findById(int id) {
        List<AdminEntity> admins = findAllAdmins();
        for (AdminEntity admin : admins) {
            if (admin.getId() == id) {
                return admin;
            }
        }
        return null;
    }

}
