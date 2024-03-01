package com.rabin.hotelproject.controller;

import com.rabin.hotelproject.dto.AdministrationDto;
import com.rabin.hotelproject.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdministrationController {

    @Autowired
    private AdministrationService administrationService;

    @PostMapping
    public ResponseEntity<AdministrationDto> registeringAdministrationInfo(@RequestBody AdministrationDto administrationDto) throws ParseException {
        return ResponseEntity.ok(administrationService.savingTheRecordOfAdministrationInDatabase(administrationDto));
    }

    @GetMapping
    public List<AdministrationDto> gettingListOfRecord(){
        return administrationService.allRecordOfAdministration();
    }



}
