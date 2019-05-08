package com.electricity.controller;

import com.electricity.service.SignalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignalController {

    private final SignalService signalService;

    public SignalController(SignalService signalService) {
        this.signalService = signalService;
    }


    @GetMapping("/user-signals")
    public String userSignals() {

        return "user-signals";
    }


    public String StringpostSignal() {
        //TODO
        return "";
    }
}
