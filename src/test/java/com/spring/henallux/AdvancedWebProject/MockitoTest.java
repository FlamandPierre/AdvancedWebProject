package com.spring.henallux.AdvancedWebProject;

import com.spring.henallux.AdvancedWebProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.AdvancedWebProject.dataAccess.dao.ItemDAO;
import com.spring.henallux.AdvancedWebProject.dataAccess.dao.OrderDAO;
import com.spring.henallux.AdvancedWebProject.dataAccess.entity.BoardGameEntity;
import com.spring.henallux.AdvancedWebProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.AdvancedWebProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.AdvancedWebProject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.AdvancedWebProject.dataAccess.repository.ItemRepository;
import com.spring.henallux.AdvancedWebProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.AdvancedWebProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.AdvancedWebProject.model.Category;
import com.spring.henallux.AdvancedWebProject.model.Item;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
class MockitoTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ProviderConverter providerConverter;

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderDAO orderDAO;

    @InjectMocks
    private ItemDAO itemDAO;

    @InjectMocks
    private CategoryDAO categoryDAO;

    @Test
    public void testGetAllCategories() {
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setLabel("Category 1");
        categoryEntities.add(categoryEntity1);

        CategoryEntity categoryEntity2 = new CategoryEntity();
        categoryEntity2.setLabel("Category 2");
        categoryEntities.add(categoryEntity2);

        when(categoryRepository.findAll()).thenReturn(categoryEntities);

        Category categoryModel1 = new Category();
        categoryModel1.setLabel("Category 1");
        when(providerConverter.categoryEntityToCategoryModel(categoryEntity1)).thenReturn(categoryModel1);

        Category categoryModel2 = new Category();
        categoryModel2.setLabel("Category 2");
        when(providerConverter.categoryEntityToCategoryModel(categoryEntity2)).thenReturn(categoryModel2);

        ArrayList<Category> result = categoryDAO.getAllCategories();
        ArrayList<Category> expected = new ArrayList<>();
        expected.add(categoryModel1);
        expected.add(categoryModel2);

        assertEquals(expected, result);
    }


    @Test
    public void testFindAll() {
        ArrayList<BoardGameEntity> boardGameEntities = new ArrayList<>();
        BoardGameEntity boardGameEntity1 = new BoardGameEntity();
        boardGameEntity1.setName("Board Game 1");
        boardGameEntities.add(boardGameEntity1);

        BoardGameEntity boardGameEntity2 = new BoardGameEntity();
        boardGameEntity2.setName("Board Game 2");
        boardGameEntities.add(boardGameEntity2);

        when(itemRepository.findAll()).thenReturn(boardGameEntities);

        Item itemModel1 = new Item();
        itemModel1.setName("Board Game 1");
        when(providerConverter.boardGameEntityToItemModel(boardGameEntity1)).thenReturn(itemModel1);

        Item itemModel2 = new Item();
        itemModel2.setName("Board Game 2");
        when(providerConverter.boardGameEntityToItemModel(boardGameEntity2)).thenReturn(itemModel2);

        ArrayList<Item> result = itemDAO.findAll();
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(itemModel1);
        expected.add(itemModel2);

        assertEquals(expected, result);
    }

    @Test
    public void testUpdateIsPaid() {
        String username = "test";
        boolean isPaid = true;
        OrderEntity orderEntity = mock(OrderEntity.class);
        when(orderRepository.findFirstByeMailUserOrderByIdDesc(eq(username))).thenReturn(orderEntity);
        orderDAO.updateIsPaid(isPaid, username);
        verify(orderEntity, times(1)).setIsPaid(eq(isPaid));
        verify(orderRepository, times(1)).save(eq(orderEntity));
    }
}
