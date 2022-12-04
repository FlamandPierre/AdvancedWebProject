package com.spring.henallux.AdvancedWebProject.model;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Validated
public class UserForm {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String passwordConfirmation;
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;
    @NotEmpty
    @Email
    private String email;
    private Date creationDate;
    @NotEmpty
    private String address;
    @NotEmpty
    @Pattern(regexp = "^$|([0-9]{9,13})")
    private String phoneNumber;
    private Date birthdate;

    public UserForm() {}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
