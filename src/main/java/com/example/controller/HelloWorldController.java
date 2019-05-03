package com.example.controller;

import com.example.model.Message;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController  extends BaseController {

    private static final String MESSAGE = "Hello, World!";

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Message hello() {
        Message message = new Message("Hello world!");
        message.setMessage(MESSAGE);
        return message;
    }

}
