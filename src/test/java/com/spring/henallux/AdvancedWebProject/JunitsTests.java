package com.spring.henallux.AdvancedWebProject;

import com.spring.henallux.AdvancedWebProject.model.Cart;
import com.spring.henallux.AdvancedWebProject.model.Item;
import com.spring.henallux.AdvancedWebProject.model.Order;
import com.spring.henallux.AdvancedWebProject.model.OrderLine;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

class JunitsTests {

	@Test
	public void testSetQuantity() {
		OrderLine example = new OrderLine();

		// Test quantity less than 1
		example.setQuantity(0);
		assertEquals(1, example.getQuantity());

		// Test quantity greater than 99
		example.setQuantity(100);
		assertEquals(99, example.getQuantity());

		// Test quantity between 1 and 99
		example.setQuantity(50);
		assertEquals(50, example.getQuantity());
	}


	@Test
	public void testPromotionAmountWithValidInput() {
		Item item = new Item();
		double unitPrice = 100;
		int promotion = 10;
		double expected = 90.00;
		double result = item.getPromotionAmount(promotion, unitPrice);

		assertEquals(expected, result, 0.01);
	}

	@Test
	public void testGetTotalReduction() {
		Cart cart = new Cart();
		Item item = new Item();
		item.setName("truc");
		item.setUnitPrice(100.00);
		OrderLine orderLine = new OrderLine(item, 1);
		cart.addItems(orderLine);

		double reduction = 1000; //car 1 point = 1 centime donc 10 euros = 1000 points
		double expected = 90;
		double result = cart.getTotalReduction(reduction);

		assertEquals(expected, result, 0.01);
	}

}
