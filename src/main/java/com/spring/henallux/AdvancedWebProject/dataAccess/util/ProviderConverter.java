package com.spring.henallux.AdvancedWebProject.dataAccess.util;

import com.spring.henallux.AdvancedWebProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.AdvancedWebProject.model.Category;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    private Mapper mapper = new DozerBeanMapper();

    //Entity -> Model
    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        return mapper.map(categoryEntity, Category.class);
    }
}
