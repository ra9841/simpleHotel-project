package com.rabin.hotelproject.repository;

import com.rabin.hotelproject.entity.Administration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministrationRepository extends JpaRepository<Administration, Long> {
    Optional<Administration> findByEmail(String email);
}
