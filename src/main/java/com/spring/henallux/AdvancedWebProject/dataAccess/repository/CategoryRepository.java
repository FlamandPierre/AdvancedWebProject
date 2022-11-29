package com.spring.henallux.AdvancedWebProject.dataAccess.repository;

import com.spring.henallux.AdvancedWebProject.dataAccess.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}