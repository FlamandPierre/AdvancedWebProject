package com.spring.henallux.AdvancedWebProject.dataAccess.dao;


import com.spring.henallux.AdvancedWebProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.AdvancedWebProject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.AdvancedWebProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.AdvancedWebProject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryDAO implements CategoryDataAccess {

    private CategoryRepository categoryRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CategoryDAO(CategoryRepository categoryRepository, ProviderConverter providerConverter) {
        this.categoryRepository = categoryRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public ArrayList<Category> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        ArrayList<Category> categories = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoryEntities) {
            Category category = providerConverter.categoryEntityToCategoryModel(categoryEntity);
            categories.add(category);
        }
        return categories;
    }

    @Override
    public Category getCategory(String label) {
        CategoryEntity categoryEntity = categoryRepository.getById(label);
        return providerConverter.categoryEntityToCategoryModel(categoryEntity);
    }
}
