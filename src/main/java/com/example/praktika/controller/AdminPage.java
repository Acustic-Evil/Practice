package com.example.praktika.controller;

import com.example.praktika.entity.AdminEntity;
import com.example.praktika.entity.InstrumentEntity;
import com.example.praktika.service.IAdminService;
import com.example.praktika.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/admin")
@CrossOrigin("http://localhost:3000/")
public class AdminPage {

    @Autowired
    IAdminService adminService;

    @Autowired
    InstrumentService instrumentService;


    @GetMapping("/main") // done for react
    public List<InstrumentEntity> getAdminPage()  {
        return instrumentService.findAllInstruments();
    }

    @GetMapping("/sign_up") // done for react
    public List<AdminEntity> getSignUpPage() {
        return adminService.findAllAdmins();
    }

    @PostMapping("/sign_up") // TODO: refactor for react
    public String createNewAdmin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        if(adminService.addNewAdmin("admin", username, password)) {
            return "redirect:/admin/sign_up";
        }
        else {return "redirect:/admin/sign_up";}
    }

    /*@PostMapping("/add_new_instrument") // TODO: refactor for react
    public String addNewInstrument(@RequestParam(value = "instrument_name") String instrument_name,
                                   @RequestParam(value = "num_of_strings") Integer num_of_strings,
                                   @RequestParam(value = "factory_name") String factory_name,
                                   @RequestParam(value = "factory_number") String factory_number) {
        if(instrumentService.addNewInstrument(instrument_name, num_of_strings, factory_number, factory_name)) {
            return "redirect:/admin";
        } else {
            return "redirect:/admin";
        }

    }*/

    @PostMapping("/add_new_instrument")
    public ResponseEntity<InstrumentEntity> addNewInstrument(@RequestBody InstrumentEntity instrument) {
        InstrumentEntity createNewInstrument = instrumentService.addNewInstrument(instrument);
        return ResponseEntity.ok(createNewInstrument);
    }

    @GetMapping("/add_new_instrument")
    public ResponseEntity<List<InstrumentEntity>> getInstruments(){
        List<InstrumentEntity> instruments = instrumentService.findAllInstruments();
        return ResponseEntity.ok(instruments);
    }

    @GetMapping("/delete_admin/{id}") //по факту DeleteMapping | TODO: refactor for react
    private String delete_admin(@PathVariable int id) {
        adminService.delete(id);
        return "redirect:/admin/sign_up";
    }

    @DeleteMapping("/delete_instrument/{id}")
    private ResponseEntity<Long> delete_instrument(@PathVariable Long id) {
        instrumentService.delete(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/edit_instrument/{id}")
    public List<InstrumentEntity> getEditInstrument(@PathVariable Long id) {
        List<InstrumentEntity> instrument = new ArrayList<>();
        instrument.add(instrumentService.findById(id));
        return instrument;
    }

    @PostMapping("/edit_instrument/{id}") // TODO: refactor for react
    public String editInstrument(@PathVariable Long id,
                                 @RequestParam(value = "instrument_name") String instrument_name,
                                 @RequestParam(value = "num_of_strings") Integer num_of_strings,
                                 @RequestParam(value = "factory_name") String factory_name,
                                 @RequestParam(value = "factory_number") String factory_number) {
        InstrumentEntity instrument = new InstrumentEntity(id, instrument_name, num_of_strings, factory_number, factory_name);
        instrumentService.update(instrument);
        return "redirect:/admin";
    }
}
