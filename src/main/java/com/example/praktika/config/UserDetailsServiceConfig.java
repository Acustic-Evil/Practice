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
    private IAdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        System.out.println(login);
        AdminEntity adminSystem = adminRepository.findByUsername(login);
        if(adminSystem == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(adminSystem.getRole());
        UserDetails  userDetails = new User(adminSystem.getUsername(),adminSystem.getPassword(), List.of(authority));

        System.out.println(userDetails.getUsername() +":"+userDetails.getPassword()+". Role"+userDetails.getAuthorities());
        return userDetails;
    }
}
