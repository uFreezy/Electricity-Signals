package com.electricity.controller;

import com.electricity.service.RoleService;
import com.electricity.service.SecurityService;
import com.electricity.service.SignalService;
import com.electricity.service.UserService;

public class BaseController {
    private RoleService roleService;
    private SecurityService securityService;
    private SignalService signalService;
    private UserService userService;

    public BaseController(RoleService roleService, SecurityService securityService, SignalService signalService, UserService userService) {
        this.roleService = roleService;
        this.securityService = securityService;
        this.signalService = signalService;
        this.userService = userService;
    }
}
