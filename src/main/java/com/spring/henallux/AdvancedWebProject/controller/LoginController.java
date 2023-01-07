package com.spring.henallux.AdvancedWebProject.controller;

import com.spring.henallux.AdvancedWebProject.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String getLogin(Model model) {
        model.addAttribute("user", new User());
        return "integrated:login";
    }
}
