package com.example.praktika.service;

import com.example.praktika.entity.AdminEntity;
import com.example.praktika.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public boolean addNewAdmin( String role, String username, String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(!saveAdmin(new AdminEntity("admin", username, bCryptPasswordEncoder.encode(password)))){
            return false;
        }
        System.out.println("New user: "+username + " " +role);
        return true;
    }

    public boolean saveAdmin(AdminEntity admin){
        AdminEntity userFromJson = adminRepository.findByUsername(admin.getUsername());

        if(userFromJson!=null) {
            return false;
        }
        adminRepository.save(admin);
        return true;
    }

}
