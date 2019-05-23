package com.electricity.controller;

import com.electricity.dto.DirectorServicemanDto;
import com.electricity.dto.DirectorSignalDto;
import com.electricity.dto.DirectorSignalGroupDto;
import com.electricity.service.RoleService;
import com.electricity.service.SignalService;
import com.electricity.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@PreAuthorize("hasAuthority('Director')")
public class AdminController {
    private final SignalService signalService;
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(SignalService signalService, UserService userService, RoleService roleService) {
        this.signalService = signalService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin/index")
    public String index(Model model) {
        List<DirectorSignalDto> signalInfo = new ArrayList<>();
        List<DirectorServicemanDto> servicemanInfo = new ArrayList<>();

        signalService.findAllResolved().forEach(s -> signalInfo.add(new DirectorSignalDto(s.getAddress(),
                s.getDescription(),
                (int) ((s.getDateOnCompletion().getTime() - s.getDateOnSubmition().getTime())
                        / (1000 * 60 * 60 * 24)))));

        userService.findByRoles(Collections.singletonList(roleService.findByName("Service")))
                .forEach(u -> servicemanInfo.add(new DirectorServicemanDto(u.getUsername(), u.getSolvedSignals().size())));


        DirectorSignalGroupDto info = new DirectorSignalGroupDto(((int) this.signalService.count()), signalInfo, servicemanInfo);

        model.addAttribute("info", info);

        return "admin/index";
    }
}
