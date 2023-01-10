package com.spring.henallux.AdvancedWebProject.dataAccess.repository;

import com.spring.henallux.AdvancedWebProject.dataAccess.entity.CategoryTranslationEntity;
import com.spring.henallux.AdvancedWebProject.dataAccess.util.CategoryTranslationKey;
import com.spring.henallux.AdvancedWebProject.model.CategoryTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryTranslationRepository extends JpaRepository<CategoryTranslationEntity, CategoryTranslationKey> {
    CategoryTranslationEntity findByLanguageCodeAndCategoryLabel(String languageCode, String categoryLabel);
}
