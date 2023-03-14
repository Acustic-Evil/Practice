package com.example.praktika.controller;

import com.example.praktika.entity.AdminEntity;
import com.example.praktika.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public String getSignUpPage(Model model) {
        List<AdminEntity> adminList = adminService.findAllAdmins();
        model.addAttribute("adminList", adminList);
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String createNewAdmin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        if(adminService.addNewAdmin("admin", username, password)) {
            return "redirect:/admin/sign_up";
        }
        else {return "redirect:/admin/sign_up";}
    }

    @GetMapping("/delete_admin/{id}")
    private String delete_admin(@PathVariable int id){
        adminService.delete(id);
        return "redirect:/admin/sign_up";
    }
}
