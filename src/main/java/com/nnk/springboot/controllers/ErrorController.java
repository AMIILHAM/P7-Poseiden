package com.nnk.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/403")
    public String accessDenied(Model model) {
        model.addAttribute("errorMessage", "Access Denied: You don't have permission to access this resource.");
        return "403";
    }
}