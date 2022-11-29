package com.spring.henallux.AdvancedWebProject.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class User implements UserDetails {

    private Integer id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private Integer loyaltyPoints;
    private Date creationDate;
    private String address;
    private String phoneNumber;
    private Date birthdate;
    private String authorities;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;

    public User() {}

    public void setId(Integer id) { this.id = id; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setEmail(String email) { this.email = email; }
    public void setLoyaltyPoints(Integer loyaltyPoints) { this.loyaltyPoints = loyaltyPoints; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }

    public Integer getId() { return id; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getEmail() { return email; }
    public Integer getLoyaltyPoints() { return loyaltyPoints; }
    public Date getCreationDate() { return creationDate; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public Date getBirthdate() { return birthdate; }

    //Security Management
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setAuthorities(String authorities) { this.authorities = authorities; }
    public void setAccountNonExpired(Boolean accountNonExpired) { this.accountNonExpired = accountNonExpired; }
    public void setAccountNonLocked(Boolean accountNonLocked) { this.accountNonLocked = accountNonLocked; }
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) { this.credentialsNonExpired = credentialsNonExpired; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }

    @Override
    public String getUsername() { return username; }
    @Override
    public String getPassword() { return password; }
    @Override
    public boolean isAccountNonExpired() { return accountNonExpired; }
    @Override
    public boolean isAccountNonLocked() { return accountNonLocked; }
    @Override
    public boolean isCredentialsNonExpired() { return credentialsNonExpired; }
    @Override
    public boolean isEnabled() { return enabled; }
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (authorities != null && !authorities.isEmpty()) {
            String[] authoritiesAsArray = authorities.split(",");
            for (String authority : authoritiesAsArray) {
                if (authority != null && !authority.isEmpty()) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority));
                }
            }
        }
        return grantedAuthorities;
    }

}
