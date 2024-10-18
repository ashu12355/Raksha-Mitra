package com.rakshamitra.RakshaMitra.service;

import java.util.List;

import java.util.Optional;

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
        if (rescueAgencyRepository.findByEmail(agency.getEmail()) != null) {
            throw new IllegalArgumentException("Email already in use");
        }
        return rescueAgencyRepository.save(agency);
    }

    public void approveAgency(Long id) {
        RescueAgency agency = rescueAgencyRepository.findById(id).orElse(null);
        if (agency != null) {
            agency.setApproved(true);
            rescueAgencyRepository.save(agency);
        }
    }
    public List<RescueAgency> findAllPendingAgencies() {
        return rescueAgencyRepository.findByApproved(false);
    }

    
    
}
