package com.example.praktika.controller;

import com.example.praktika.entity.AdminEntity;
import com.example.praktika.entity.InstrumentEntity;
import com.example.praktika.service.IAdminService;
import com.example.praktika.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminPage {

    @Autowired
    IAdminService adminService;

    @Autowired
    InstrumentService instrumentService;

    @GetMapping("/api/instruments")
    @ResponseBody
    public List<InstrumentEntity> getInstruments() {
        return instrumentService.findAllInstruments();
    }


    @GetMapping("")
    public String getAdminPage(Model instrumenModel)  {
        List<InstrumentEntity> instrumentList = instrumentService.findAllInstruments();
        instrumenModel.addAttribute("instrumentList", instrumentList);
        return "admin";
    }

    @GetMapping("/sign_up")
    public String getSignUpPage(Model adminModel) {
        List<AdminEntity> adminList = adminService.findAllAdmins();
        adminModel.addAttribute("adminList", adminList);
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String createNewAdmin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        if(adminService.addNewAdmin("admin", username, password)) {
            return "redirect:/admin/sign_up";
        }
        else {return "redirect:/admin/sign_up";}
    }

    @PostMapping("/add_new_instrument")
    public String addNewInstrument(@RequestParam(value = "instrument_name") String instrument_name,
                                   @RequestParam(value = "num_of_strings") Integer num_of_strings,
                                   @RequestParam(value = "factory_name") String factory_name,
                                   @RequestParam(value = "factory_number") String factory_number) {
        if(instrumentService.addNewInstrument(instrument_name, num_of_strings, factory_number, factory_name)) {
            return "redirect:/admin";
        } else {
            return "redirect:/admin";
        }

    }

    @GetMapping("/delete_admin/{id}") //по факту DeleteMapping
    private String delete_admin(@PathVariable int id) {
        adminService.delete(id);
        return "redirect:/admin/sign_up";
    }

    @GetMapping("/delete_instrument/{id}") //по факту DeleteMapping
    private String delete_instrument(@PathVariable int id) {
        instrumentService.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("/edit_instrument/{id}")
    public String getEditInstrument(@PathVariable int id, Model model) {
        List<InstrumentEntity> instrument = new ArrayList<>();
        instrument.add(instrumentService.findById(id));
        model.addAttribute("instrument", instrument);
        return "edit_instrument";
    }

    @PostMapping("/edit_instrument/{id}")
    public String editInstrument(@PathVariable int id,
                                 @RequestParam(value = "instrument_name") String instrument_name,
                                 @RequestParam(value = "num_of_strings") Integer num_of_strings,
                                 @RequestParam(value = "factory_name") String factory_name,
                                 @RequestParam(value = "factory_number") String factory_number) {
        InstrumentEntity instrument = new InstrumentEntity(id, instrument_name, num_of_strings, factory_number, factory_name);
        instrumentService.update(instrument);
        return "redirect:/admin";
    }
}
