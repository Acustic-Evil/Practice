package com.example.praktika.controller;

import com.example.praktika.entity.InstrumentEntity;
import com.example.praktika.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPage {
    @Autowired
    InstrumentService instrumentService;
    @GetMapping("")
    public String getMainPage(Model instrumenModel) {
        List<InstrumentEntity> instrumentList = instrumentService.findAllInstruments();
        instrumenModel.addAttribute("instrumentList", instrumentList);
        return "index";
    }

    @GetMapping("/sign_in")
    public String getSignInPage(){
        return "sign_in";
    }
}