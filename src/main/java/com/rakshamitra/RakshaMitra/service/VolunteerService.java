package com.rakshamitra.RakshaMitra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakshamitra.RakshaMitra.model.Volunteer;
import com.rakshamitra.RakshaMitra.repository.VolunteerRepository;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    public Volunteer findByEmail(String email) {
        return volunteerRepository.findByEmail(email);
    }

    public Volunteer saveVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }
    
}
