package com.rakshamitra.RakshaMitra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rakshamitra.RakshaMitra.model.Admin;
import com.rakshamitra.RakshaMitra.service.AdminService;


@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/login")
    public String showAdminLoginPage() {
        return "admin_login";
    }

    @PostMapping("/admin/login")
    public String adminLogin(String email, String password, Model model) {
        Admin admin = adminService.findByEmail(email);
        if (admin != null && admin.getPassword().equals(password)) {
            return "admin_dashboard"; // Redirect to admin dashboard //Amit You have to built Later 
        }
        model.addAttribute("error", "Invalid credentials");
        return "admin_login";
    }
    
}
