package com.rakshamitra.RakshaMitra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rakshamitra.RakshaMitra.model.RescueAgency;
import com.rakshamitra.RakshaMitra.service.RescueAgencyService;

@Controller
public class RescueAgencyController {
    @Autowired
    private RescueAgencyService rescueAgencyService;

    @GetMapping("/rescueagency/login")
    public String showAgencyLoginPage() {
        return "rescue_agency_login";
    }

    @GetMapping("/rescueagency/register")
    public String showAgencyRegistartionPage() {
        return "rescue_agency_reg";
    }

    @PostMapping("/rescueagency/login")
    public String agencyLogin(String email, String password, Model model) {
        RescueAgency agency = rescueAgencyService.findByEmail(email);
        if (agency != null && agency.getPassword().equals(password)) {
            return "agency_dashboard"; // Redirect to agency dashboard // Later Work
        }
        model.addAttribute("error", "Invalid credentials");
        return "rescue_agency_login";
    }
    @PostMapping("/rescueagency/register")
    public String registerAgency(RescueAgency agency, Model model) {
        rescueAgencyService.saveAgency(agency);
        return "rescue_agency_login"; // Redirect to login page after successful registration
    }
    
}
