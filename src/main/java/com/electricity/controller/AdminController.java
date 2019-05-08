package com.electricity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasAuthority('Director')")
public class AdminController {

    @GetMapping("/admin/index")
    public String index() {
        return "admin/index";
    }
}
