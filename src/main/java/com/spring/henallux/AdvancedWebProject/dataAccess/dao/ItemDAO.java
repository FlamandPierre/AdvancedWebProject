package com.spring.henallux.AdvancedWebProject.dataAccess.dao;

import com.spring.henallux.AdvancedWebProject.dataAccess.entity.BoardGameEntity;
import com.spring.henallux.AdvancedWebProject.dataAccess.repository.ItemRepository;
import com.spring.henallux.AdvancedWebProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.AdvancedWebProject.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class ItemDAO implements ItemDataAccess {
    private ItemRepository itemRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public ItemDAO(ItemRepository itemRepository, ProviderConverter providerConverter) {
        this.itemRepository = itemRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public ArrayList<Item> findAll() {
        ArrayList<BoardGameEntity> boardGameEntities = itemRepository.findAll();
        ArrayList<Item> items = new ArrayList<>();
        for (BoardGameEntity entity : boardGameEntities) {
            Item item = providerConverter.boardGameEntityToItemModel(entity);
            items.add(item);
        }
        return items;
    }

    @Override
    public Item findByName(String name) {
        BoardGameEntity boardGameEntity = itemRepository.findByName(name);
        return providerConverter.boardGameEntityToItemModel(boardGameEntity);
    }
}
