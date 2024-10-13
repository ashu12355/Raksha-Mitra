package com.rakshamitra.RakshaMitra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rakshamitra.RakshaMitra.model.Volunteer;
import com.rakshamitra.RakshaMitra.service.VolunteerService;

@Controller
public class VolunteerController {
    
    @Autowired
    private VolunteerService volunteerService;

     @GetMapping("/volunteer/login")
    public String showVolunteerLoginPage() {
        return "volunteer_login";
    }

     @PostMapping("/volunteer/login")
    public String volunteerLogin(String email, String password, Model model) {
        Volunteer volunteer = volunteerService.findByEmail(email);
        if (volunteer != null && volunteer.getPassword().equals(password)) {
            return "volunteer_dashboard"; // Redirect to volunteer dashboard  //Done later
        }
        model.addAttribute("error", "Invalid credentials");
        return "volunteer_login";
    }

    @GetMapping("/volunteer/register")
    public String showVolunteerRegistrationPage() {
        return "volunteer_registration";
    }

    @PostMapping("/volunteer/register")
    public String registerVolunteer(Volunteer volunteer, Model model) {
        volunteerService.saveVolunteer(volunteer);
        return "volunteer_login"; // Redirect to login page after successful registration
    }
}
