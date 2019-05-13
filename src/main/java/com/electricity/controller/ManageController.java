package com.electricity.controller;

import com.electricity.model.Signal;
import com.electricity.service.SignalService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller

@PreAuthorize("hasAuthority('Service')")
public class ManageController {

    private final SignalService signalService;

    public ManageController(SignalService signalService) {
        this.signalService = signalService;
    }

    @GetMapping("/manage/index")
    public String index(Model model) {

        List<Signal> unresolvedSignals = signalService.findAllUnresolved();

        if (!unresolvedSignals.isEmpty())
            model.addAttribute("signals", unresolvedSignals);
        else
            model.addAttribute("error", "Hooray! You have no unresolved signals");

        return "manage/index";
    }


    @PostMapping("/manage/resolve")
    public String resolveSignal(@RequestParam String id) {
        Signal signal = this.signalService.findById(Long.parseLong(id));
        signal.setIsCompleted(true);
        signal.setDateOnCompletion(new Date());

        this.signalService.save(signal);

        return "redirect:/manage/index";
    }
}
