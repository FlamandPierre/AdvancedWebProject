package com.spring.henallux.AdvancedWebProject.controller;

import com.spring.henallux.AdvancedWebProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAccount(Authentication authentication, Model model) {
        User userDetails = (User) authentication.getPrincipal();
        model.addAttribute("currentUser",userDetails);
        return "integrated:account";
    }
}
