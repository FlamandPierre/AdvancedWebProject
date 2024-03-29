package com.spring.henallux.AdvancedWebProject.dataAccess.util;

import com.spring.henallux.AdvancedWebProject.dataAccess.entity.*;
import com.spring.henallux.AdvancedWebProject.model.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;

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

    public CategoryTranslation categoryTranslationEntityToCategoryTranslation(CategoryTranslationEntity categoryTranslationEntity) {
        return mapper.map(categoryTranslationEntity, CategoryTranslation.class);
    }

    //Model -> Entity
    public UserEntity userModelToUserEntity(User user) {
        return mapper.map(user, UserEntity.class);
    }

    public OrderEntity orderModelToOrderEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(order.getDate());
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        String test = year + "-" + month + 1 + "-" + day;

        orderEntity.setDate(Date.valueOf(test));
        orderEntity.setIsPaid(order.getIsPaid());
        orderEntity.setReduction(order.getReduction());
        orderEntity.setEMailUser(order.getUser().getUsername());

        return orderEntity;
    }

    public OrderLineEntity orderLineToOrderLineEntity(OrderLine orderLine, Integer orderId) {
        OrderLineEntity orderLineEntity = new OrderLineEntity();

        orderLineEntity.setQuantity(orderLine.getQuantity());
        orderLineEntity.setPrice(orderLine.getTotal());
        orderLineEntity.setIdOrder(orderLine.getCompositeKey().getIdOrder());
        orderLineEntity.setIdBoardGame(orderLine.getCompositeKey().getIdBoardGame());

        return orderLineEntity;
    }

    public Item boardGameEntityToItemModel(BoardGameEntity boardGameEntity) {
        Item item = new Item();

        item.setId(boardGameEntity.getId());
        item.setName(boardGameEntity.getName());
        item.setDescription(boardGameEntity.getDescription());
        item.setUnitPrice(boardGameEntity.getPrice());
        item.setCategoryId(boardGameEntity.getCategory().getLabel());
        item.setReduction(new Reduction());

        return item;
    }
}
