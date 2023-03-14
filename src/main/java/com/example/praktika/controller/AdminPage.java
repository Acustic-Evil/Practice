package com.example.praktika.controller;

import com.example.praktika.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin")
public class AdminPage {

    @Autowired
    AdminService adminService;

    @GetMapping("")
    public String getAdminPage()  {

        return "admin";
    }

    @GetMapping("/sign_up")
    public String getSignUpPage() {
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String createNewAdmin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        if(adminService.addNewAdmin("admin", username, password )) {
            return "redirect:/admin";
        }
        else {return "redirect:/admin";}
    }

}
