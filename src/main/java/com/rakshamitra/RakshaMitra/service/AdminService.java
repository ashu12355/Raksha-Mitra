package com.rakshamitra.RakshaMitra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakshamitra.RakshaMitra.model.Admin;
import com.rakshamitra.RakshaMitra.repository.AdminRepository;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;

    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

}
