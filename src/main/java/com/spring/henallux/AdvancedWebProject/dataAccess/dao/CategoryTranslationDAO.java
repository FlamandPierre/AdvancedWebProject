package com.spring.henallux.AdvancedWebProject.dataAccess.dao;

import com.spring.henallux.AdvancedWebProject.dataAccess.entity.CategoryTranslationEntity;
import com.spring.henallux.AdvancedWebProject.dataAccess.repository.CategoryTranslationRepository;
import com.spring.henallux.AdvancedWebProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.AdvancedWebProject.model.CategoryTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryTranslationDAO implements CategoryTranslationDataAccess {

    private CategoryTranslationRepository categoryTranslationRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CategoryTranslationDAO(CategoryTranslationRepository categoryTranslationRepository, ProviderConverter providerConverter) {
        this.categoryTranslationRepository = categoryTranslationRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public CategoryTranslation getCategoryTranslationByLanguageCodeAndCategoryLabel(String languageCode, String categoryLabel) {
        CategoryTranslationEntity categoryTranslationEntity = categoryTranslationRepository.findByLanguageCodeAndCategoryLabel(languageCode, categoryLabel);
        return providerConverter.categoryTranslationEntityToCategoryTranslation(categoryTranslationEntity);
    }

    @Override
    public ArrayList<CategoryTranslation> getAllCategoryTranslations() {
        List<CategoryTranslationEntity> categoryTranslationEntities = categoryTranslationRepository.findAll();
        ArrayList<CategoryTranslation> categoryTranslations = new ArrayList<>();
        for (CategoryTranslationEntity categoryTranslationEntity : categoryTranslationEntities) {
            CategoryTranslation categoryTranslation = providerConverter.categoryTranslationEntityToCategoryTranslation(categoryTranslationEntity);
            categoryTranslations.add(categoryTranslation);
        }
        return categoryTranslations;
    }
}
