package com.spring.henallux.AdvancedWebProject.dataAccess.repository;

import com.spring.henallux.AdvancedWebProject.dataAccess.entity.BoardGameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
@Repository
public interface ItemRepository extends JpaRepository<BoardGameEntity, Integer> {
    ArrayList<BoardGameEntity> findAll();
    BoardGameEntity findByName(String name);
    ArrayList<BoardGameEntity> findByCategory(String label);
}
