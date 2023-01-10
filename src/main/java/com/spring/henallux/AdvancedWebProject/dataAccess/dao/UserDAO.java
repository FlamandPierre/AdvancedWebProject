package com.spring.henallux.AdvancedWebProject.dataAccess.dao;

import com.spring.henallux.AdvancedWebProject.dataAccess.entity.UserEntity;
import com.spring.henallux.AdvancedWebProject.dataAccess.repository.UserRepository;
import com.spring.henallux.AdvancedWebProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.AdvancedWebProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDAO implements UserDataAccess{
    private UserRepository userRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public UserDAO(UserRepository userRepository, ProviderConverter providerConverter) {
        this.userRepository = userRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public User findByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        User user = providerConverter.userEntityToUserModel(userEntity);
        return user;
    }

    @Override
    public User addUser(User newUser) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword;
        encryptedPassword = encoder.encode(newUser.getPassword());
        newUser.setPassword(encryptedPassword);
        UserEntity newUserEntity = providerConverter.userModelToUserEntity(newUser);
        newUserEntity = userRepository.save(newUserEntity);
        return providerConverter.userEntityToUserModel(newUserEntity);
    }

    @Override
    public Boolean exists(String username) {
        return userRepository.existsById(username);
    }

    @Transactional
    @Override
    public void updatePoints(String username, Integer points) {
        UserEntity userEntity = userRepository.findByUsername(username);
        userEntity.setLoyaltyPoints(points);
        userRepository.save(userEntity);
    }
}
