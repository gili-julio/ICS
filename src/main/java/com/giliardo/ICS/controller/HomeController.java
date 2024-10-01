package com.giliardo.ICS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String telaIndex(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String telaLogin(Model model) {
        return "login";
    }

    @GetMapping("/teste")
    public String telaTeste(Model model) {
        return "teste";
    }

}
