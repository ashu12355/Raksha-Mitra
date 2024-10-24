package com.rakshamitra.RakshaMitra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rakshamitra.RakshaMitra.forms.RescueAgencyForm;
import com.rakshamitra.RakshaMitra.model.RescueAgency;
import com.rakshamitra.RakshaMitra.service.RescueAgencyService;

import jakarta.validation.Valid;

@Controller
public class RescueAgencyController {

    @Autowired
    private RescueAgencyService rescueAgencyService;

    @GetMapping("/rescueagency/login")
    public String showAgencyLoginPage() {
        return "rescue_agency_login";
    }

    @GetMapping("/rescueagency/register")
    public String showAgencyRegistrationPage(Model model) {
        RescueAgencyForm rescueAgencyForm = new RescueAgencyForm();
        model.addAttribute("agency", rescueAgencyForm);
        return "rescue_agency_reg";
    }

    @PostMapping("/rescueagency/login")
    public String agencyLogin(String email, String password, Model model) {
        RescueAgency agency = rescueAgencyService.findByEmail(email);
        if (agency != null && agency.isApproved() && agency.getPassword().equals(password)) {
            return "agency_dashboard";
        }
        model.addAttribute("error", "Invalid credentials or agency not approved.");
        return "rescue_agency_login";
    }

    @PostMapping("/rescueagency/register")
    public String registerAgency(@Valid @ModelAttribute RescueAgency agency, BindingResult bindingResult, Model model) {
        RescueAgencyForm rescueAgencyForm = new RescueAgencyForm();
        model.addAttribute("agency", rescueAgencyForm);
        if (bindingResult.hasErrors()) {
            return "rescue_agency_reg";
        }
        else {
            rescueAgencyService.saveAgency(agency);
            return "rescue_agency_login";
        }
          
    }

    @PostMapping("/admin/approve_agencies")
    public String approveAgency(@RequestParam Long agencyId, Model model) {
        rescueAgencyService.approveAgency(agencyId);
        model.addAttribute("message", "Agency approved successfully!");
        return "redirect:/admin/approve_agencies";
    }

    @GetMapping("/logout")
    public String logout(Authentication authentication) {
        if (authentication != null) {

        }
        return "redirect:/login";
    }

    @GetMapping("/rescueagency/dashboard")
    public String agencyDashboard(Authentication authentication, Model model) {
        // Check if authentication is not null
        if (authentication != null) {
            // Get the currently logged-in agency's email from authentication
            String email = authentication.getUsername();
            System.out.println(email);
            RescueAgency agency = rescueAgencyService.findByEmail(email); // Fetch the agency details by email

            if (agency != null) {
                model.addAttribute("agency", agency); // Add agency details to the model for display
            } else {
                model.addAttribute("error", "Agency not found.");
            }
        } else {
            model.addAttribute("error", "You must be logged in to view this page.");
        }
        return "agency_dashboard";
    }
}
