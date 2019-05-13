package com.electricity.controller;

import com.electricity.service.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private SecurityService securityService;

    public HomeController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/")
    public String index() {
        if (this.securityService.findLoggedInUsername() == null)
            return "redirect:/login";
        else
            return "redirect:/user-signals";

    }
}
