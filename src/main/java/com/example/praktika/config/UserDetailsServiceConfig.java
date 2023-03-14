package com.example.praktika.config;

import com.example.praktika.entity.AdminEntity;
import com.example.praktika.repository.AdminRepository;
import com.example.praktika.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceConfig implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        System.out.println(login);
        AdminEntity admin = adminRepository.findByUsername(login);
        if (admin != null) {
            GrantedAuthority authority = new SimpleGrantedAuthority(admin.getRole());
            UserDetails userDetails = new User(admin.getUsername(), admin.getPassword(), List.of(authority));
            System.out.println(userDetails.getUsername() + ":" + userDetails.getPassword() + ". Role" + userDetails.getAuthorities());
            return userDetails;
        }
        throw new UsernameNotFoundException("User not authorized.");
    }
}
