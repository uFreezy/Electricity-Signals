package com.electricity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

@PreAuthorize("hasAuthority('Service')")
public class ManageController {

    @GetMapping("/manage/index")
    public String index() {
        return "manage/index";
    }
}
