package com.rabin.hotelproject.service;

import com.rabin.hotelproject.dto.AdministrationDto;
import com.rabin.hotelproject.entity.Administration;
import com.rabin.hotelproject.exception.EmailAlreadyExistException;
import com.rabin.hotelproject.exception.InternalServerErrorException;
import com.rabin.hotelproject.repository.AdministrationRepository;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class AdministrationServiceImpl implements AdministrationService {

    @Autowired
    private AdministrationRepository administrationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Override
    public AdministrationDto savingTheRecordOfAdministrationInDatabase(AdministrationDto administrationDto) {
        Optional<Administration> existEmail = administrationRepository.findByEmail(administrationDto.getEmail());
        if (existEmail.isPresent()) {
            log.error("Email is already present in database exception {}", existEmail);
            throw new EmailAlreadyExistException("Email is already present in database");
        }

        Administration administration = new Administration();

        String lowerCaseName = administrationDto.getName().toLowerCase();
        String lowerCaseEmail = administrationDto.getEmail().toLowerCase();
        String lowerCaseRole = administrationDto.getRole().toLowerCase();
        String lowerCaseUsername = administrationDto.getUsername().toLowerCase();

        String dateOfBirthString = administrationDto.getDateOfBirth();
        try {
            String dateOfBirth = String.valueOf(new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirthString));
            administration.setDateOfBirth(dateOfBirth);
        } catch (ParseException e) {
            // Handle parsing exception
            e.printStackTrace();
            // Depending on your application's requirements, you might want to throw an exception or handle it differently
        }


        administration.setName(lowerCaseName);
        administration.setEmail(lowerCaseEmail);
        administration.setRole(lowerCaseRole);
        administration.setUsername(lowerCaseUsername);
        administration.setPassword(passwordEncoder.encode(administrationDto.getPassword()));
        administration.setCreateDate(new Date());
        administration.setModifiedDate(new Date());

        log.info("Record save in data base {}", administration);
        Administration administration1 = administrationRepository.save(administration);

        AdministrationDto administrationDto1 = new AdministrationDto();
        BeanUtils.copyProperties(administration1, administrationDto1);
        log.info("Record sending to controller from database {}", administrationDto1);
        return administrationDto1;
    }

    @Override
    @Scheduled(fixedRate = 10000)
    @Observed(name = "get.admin")  //http://localhost:8080/actuator/metrics/get.admin
    public List<AdministrationDto> allRecordOfAdministration() {
        try {
            List<Administration> administrations = administrationRepository.findAll();
            return administrations.stream().map(administration -> {
                AdministrationDto administrationDto = new AdministrationDto();
                BeanUtils.copyProperties(administration, administrationDto);
                log.info("The time is now {}", dateFormat.format(new Date()));
                log.info("List of Record from database {}", administrationDto);
                return administrationDto;
            }).toList();
        } catch (Exception e) {
            log.error("Internal Server Error exception while getting list of record {}", e);
            throw new InternalServerErrorException("Internal Server Error");
        }

    }


}
