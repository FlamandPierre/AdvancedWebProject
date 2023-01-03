package com.spring.henallux.AdvancedWebProject.controller;

import com.spring.henallux.AdvancedWebProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.AdvancedWebProject.model.User;
import com.spring.henallux.AdvancedWebProject.model.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/signUp")
public class SignUpController {

    private UserDataAccess userDAO;

    @Autowired
    public SignUpController(UserDataAccess userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getHome (Model model) {
        model.addAttribute("userForm", new UserForm());
        return "integrated:signUp";
    }

    @RequestMapping(value="/send", method = RequestMethod.POST)
    public String getFormData(Model model,
                              @Valid @ModelAttribute(value="userForm") UserForm userForm,
                              final BindingResult errors) {
        if (!errors.hasErrors()) {
            if (userDAO.exists(userForm.getUsername())) {
                errors.rejectValue("username", "emailUsed");
                System.out.println("coucou");
                return "integrated:signUp";
            }
            if (!userForm.getPasswordConfirmation().equals(userForm.getPassword())) {
                errors.rejectValue("passwordConfirmation", "unmatchedPasswords");
                System.out.println("coucou");
               return "integrated:signUp";
            }
            User newUser = new User(userForm);
            userDAO.addUser(newUser);
            return "redirect:/login";
        }
        return "integrated:signUp";
    }
}
