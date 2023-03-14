package com.example.praktika.repository;

import com.example.praktika.entity.AdminEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
public class AdminRepoImpl implements AdminRepository {
    private final String FILE_PATH = "src/main/data.json";


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
        List<AdminEntity> admins = findAllAdmins();
        admins.add(admin);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(FILE_PATH), admins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(AdminEntity admin) {
        List<AdminEntity> persons = findAllAdmins();
        for (int i = 0; i < persons.size(); i++) {
            if (Objects.equals(persons.get(i).getId(), admin.getId())) {
                persons.set(i, admin);
                break;
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(FILE_PATH), persons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {
        List<AdminEntity> persons = findAllAdmins();
        persons.removeIf(person -> person.getId() == id);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(FILE_PATH), persons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
