package com.rakshamitra.RakshaMitra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rakshamitra.RakshaMitra.model.RescueAgency;

@Repository
public interface RescueAgencyRepository extends JpaRepository<RescueAgency ,Long>  {
    RescueAgency findByEmail(String email);
}
