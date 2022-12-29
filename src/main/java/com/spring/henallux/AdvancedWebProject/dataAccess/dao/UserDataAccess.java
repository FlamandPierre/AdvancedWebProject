package com.spring.henallux.AdvancedWebProject.dataAccess.dao;

import com.spring.henallux.AdvancedWebProject.model.User;

public interface UserDataAccess {
    User findByUsername(String username);
}
