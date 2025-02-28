package com.example.cart;

import com.example.cart.model.CartItem;
import com.example.cart.repository.CartRepository;
import com.example.cart.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CartApplicationTests {

	@Mock
	private CartRepository cartRepository;

	@InjectMocks
	private CartService cartService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddToCart_NewItem() {
		Long userId = 1L;
		Long productId = 1L;
		Integer quantity = 2;

		when(cartRepository.findByUserIdAndProductId(userId, productId)).thenReturn(null);

		cartService.addToCart(userId, productId, quantity);

		verify(cartRepository, times(1)).save(any(CartItem.class));
	}

	@Test
	void testAddToCart_ExistingItem() {
		Long userId = 1L;
		Long productId = 1L;
		Integer quantity = 2;

		CartItem existingItem = new CartItem();
		existingItem.setUserId(userId);
		existingItem.setProductId(productId);
		existingItem.setQuantity(1);

		when(cartRepository.findByUserIdAndProductId(userId, productId)).thenReturn(existingItem);

		cartService.addToCart(userId, productId, quantity);

		assertEquals(3, existingItem.getQuantity());
		verify(cartRepository, times(1)).save(existingItem);
	}

	@Test
	void testGetCart() {
		Long userId = 1L;
		CartItem item1 = new CartItem();
		item1.setUserId(userId);
		item1.setProductId(1L);

		CartItem item2 = new CartItem();
		item2.setUserId(userId);
		item2.setProductId(2L);

		List<CartItem> expectedItems = Arrays.asList(item1, item2);

		when(cartRepository.findByUserId(userId)).thenReturn(expectedItems);

		List<CartItem> actualItems = cartService.getCart(userId);

		assertEquals(expectedItems, actualItems);
		verify(cartRepository, times(1)).findByUserId(userId);
	}

	@Test
	void testEmptyCart() {
		Long userId = 1L;

		cartService.emptyCart(userId);

		verify(cartRepository, times(1)).deleteByUserId(userId);
	}
}