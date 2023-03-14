package com.example.praktika.service;

import com.example.praktika.entity.AdminEntity;
import com.example.praktika.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private IAdminRepository adminRepository;

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

    public List<AdminEntity> findAllAdmins(){
        return adminRepository.findAllAdmins();
    }

    public AdminEntity findById(int id){
        return adminRepository.findById(id);
    }

    public void delete(Integer id){
        adminRepository.delete(id);
    }

}
