package com.spring.henallux.AdvancedWebProject.dataAccess.util;

import com.spring.henallux.AdvancedWebProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.AdvancedWebProject.dataAccess.entity.UserEntity;
import com.spring.henallux.AdvancedWebProject.model.Category;
import com.spring.henallux.AdvancedWebProject.model.User;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    private Mapper mapper = new DozerBeanMapper();

    //Entity -> Model
    public User userEntityToUserModel(UserEntity userEntity) {
        User user = mapper.map(userEntity, User.class);
        user.setAccountNonExpired(userEntity.getAccountNonExpired());
        user.setAccountNonLocked(userEntity.getAccountNonLocked());
        user.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
        user.setEnabled(userEntity.getEnabled());
        user.setAuthorities(userEntity.getAuthorities());
        return user;
    }

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        return mapper.map(categoryEntity, Category.class);
    }

    //Model -> Entity
    public UserEntity userModelToUserEntity(User user) {
        return mapper.map(user, UserEntity.class);
    }
}
