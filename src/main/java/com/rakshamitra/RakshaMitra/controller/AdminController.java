package com.rakshamitra.RakshaMitra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


    @GetMapping("/admin/login")
    public String showAdminLoginPage() {
        return "admin_login"; // Show login page
    }
    @GetMapping("/admin_dashboard")
    public String showAdminDashboard() {
        return "admin_dashboard";  // Admin dashboard page
    }
}
