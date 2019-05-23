package com.electricity.controller;

import com.electricity.model.Signal;
import com.electricity.service.SecurityService;
import com.electricity.service.SignalService;
import com.electricity.service.UserService;
import com.electricity.validator.SignalValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class SignalController {

    private final SignalService signalService;
    private final UserService userService;
    private final SecurityService securityService;
    private final SignalValidator signalValidator;

    public SignalController(SignalService signalService, SecurityService securityService, SignalValidator signalValidator, UserService userService) {
        this.signalService = signalService;
        this.securityService = securityService;
        this.signalValidator = signalValidator;
        this.userService = userService;
    }


    @GetMapping("/user-signals")
    public String userSignals(Model model) {
        String loggedUsername = securityService.findLoggedInUsername();

        List<Signal> signals = signalService
                .findByOwnerUsername(loggedUsername);

        Collections.reverse(signals);

        if (!signals.isEmpty())
            model.addAttribute("signals", signals);
        else
            model.addAttribute("error", "You don't have any signals added.");
        return "user-signals";
    }


    @GetMapping("/create-signal")
    public String createSignal(Model model) {
        model.addAttribute("signalForm", new Signal());

        return "create-signal";
    }

    @PostMapping("/create-signal")
    public String createSignal(@ModelAttribute("signalForm") Signal signalForm, BindingResult bindingResult) {
        signalValidator.validate(signalForm, bindingResult);

        if (bindingResult.hasErrors()) return "create-signal";

        signalForm.setDateOnSubmition(new Date());
        signalForm.setOwner(userService.findByUsername(securityService.findLoggedInUsername()));
        signalService.save(signalForm);

        return "redirect:/user-signals";
    }
}
