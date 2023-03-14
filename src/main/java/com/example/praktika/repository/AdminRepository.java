package com.example.praktika.repository;

import com.example.praktika.entity.AdminEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class AdminRepository implements IAdminRepository {
    private final String FILE_PATH = "src/main/admins.json";
    ObjectMapper objectMapper = new ObjectMapper();

    private final AtomicInteger lastId = new AtomicInteger(getLastAdminId());

    public int generateId() {
        return lastId.incrementAndGet();
    }

    public int getLastAdminId(){
        int lastId = -1;

        try {
            File file = new File(FILE_PATH);
            List<AdminEntity> admins = objectMapper.readValue(file, new TypeReference<List<AdminEntity>>() {});

            if(!admins.isEmpty()){
                AdminEntity lastAdmin = admins.get(admins.size() - 1);
                lastId = lastAdmin.getId();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastId;
    }

    @Override
    public AdminEntity findByUsername(String username) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<AdminEntity> admins = objectMapper.readValue(new File(FILE_PATH), new TypeReference<>() {
            });
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
            List<AdminEntity> admins = objectMapper.readValue(new File(FILE_PATH), new TypeReference<>() {
            });
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
