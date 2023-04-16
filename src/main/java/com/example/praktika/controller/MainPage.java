package com.example.praktika.controller;

import com.example.praktika.entity.InstrumentEntity;
import com.example.praktika.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class MainPage {

    @Autowired
    InstrumentService instrumentService;
    @GetMapping("/main")
    public List<InstrumentEntity> getMainPage() {
        return instrumentService.findAllInstruments();
    }

/*    @GetMapping("/sign_in")
    public String getSignInPage(){
        return "sign_in";
    }*/
}
