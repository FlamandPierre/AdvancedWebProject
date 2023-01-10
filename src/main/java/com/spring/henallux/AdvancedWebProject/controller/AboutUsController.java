package com.spring.henallux.AdvancedWebProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/about_us")
public class AboutUsController {
    @RequestMapping(method = RequestMethod.GET)
    public String getAboutUs(Model model) {
        return "integrated:aboutUs";
    }
}
