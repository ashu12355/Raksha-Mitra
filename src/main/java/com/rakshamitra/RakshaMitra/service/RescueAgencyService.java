package com.rakshamitra.RakshaMitra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakshamitra.RakshaMitra.model.RescueAgency;
import com.rakshamitra.RakshaMitra.repository.RescueAgencyRepository;

@Service
public class RescueAgencyService {

    @Autowired
    private RescueAgencyRepository rescueAgencyRepository;

    public RescueAgency findByEmail(String email) {
        return rescueAgencyRepository.findByEmail(email);
    }

    public RescueAgency saveAgency(RescueAgency agency) {
        return rescueAgencyRepository.save(agency);
    }
    
}
