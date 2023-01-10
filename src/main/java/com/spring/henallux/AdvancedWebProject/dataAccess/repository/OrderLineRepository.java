package com.spring.henallux.AdvancedWebProject.dataAccess.repository;

import com.spring.henallux.AdvancedWebProject.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.AdvancedWebProject.dataAccess.util.MyCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OrderLineRepository extends JpaRepository<OrderLineEntity, MyCompositeKey> {
    List<OrderLineEntity> findByIdOrderAndIdBoardGame(Integer fkOrder, Integer fkBoardgame);
}
