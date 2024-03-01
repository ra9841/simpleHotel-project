package com.rabin.hotelproject.service;

import com.rabin.hotelproject.dto.AdministrationDto;

import java.text.ParseException;
import java.util.List;

public interface AdministrationService {
    AdministrationDto savingTheRecordOfAdministrationInDatabase(AdministrationDto administrationDto) throws ParseException;

    List<AdministrationDto> allRecordOfAdministration();
}
