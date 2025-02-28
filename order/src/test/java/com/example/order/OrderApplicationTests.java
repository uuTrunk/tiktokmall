package com.example.order;

import com.example.order.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.order.dto.OrderDTO;
import com.example.order.dto.OrderItemDTO;
import com.example.order.entity.Order;
import com.example.order.entity.OrderStatus;
import com.example.order.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {

	@InjectMocks
	private OrderServiceImpl orderService;

	@Mock
	private OrderRepository orderRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCreateOrder() {
		// Arrange
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setUserId(1L);
		OrderItemDTO itemDTO = new OrderItemDTO();
		itemDTO.setProductId(101L);
		itemDTO.setQuantity(2);
		itemDTO.setPrice(BigDecimal.valueOf(10));
		orderDTO.setItems(Collections.singletonList(itemDTO));

		when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> {
			Order order = invocation.getArgument(0);
			order.setId(UUID.randomUUID().toString());
			return order;
		});

		// Act
		String orderId = orderService.createOrder(orderDTO);

		// Assert
		assertNotNull(orderId);
		verify(orderRepository, times(1)).save(any(Order.class));
	}

	@Test
	void testListOrders() {
		// Arrange
		Long userId = 1L;
		Order order = new Order();
		order.setId(UUID.randomUUID().toString());
		order.setUserId(userId);
		order.setTotalAmount(BigDecimal.valueOf(20));
		order.setStatus(OrderStatus.PENDING);
		order.setCreatedAt(LocalDateTime.now());

		when(orderRepository.findByUserId(userId)).thenReturn(Collections.singletonList(order));

		// Act
		List<OrderDTO> orders = orderService.listOrders(userId);

		// Assert
		assertFalse(orders.isEmpty());
		assertEquals(1, orders.size());
		assertEquals(order.getId(), orders.get(0).getOrderId());
		assertEquals(userId, orders.get(0).getUserId());
		verify(orderRepository, times(1)).findByUserId(userId);
	}

	@Test
	void testMarkOrderPaid() {
		// Arrange
		String orderId = UUID.randomUUID().toString();
		Order order = new Order();
		order.setId(orderId);
		order.setStatus(OrderStatus.PENDING);

		when(orderRepository.findById(orderId)).thenReturn(java.util.Optional.of(order));
		when(orderRepository.save(any(Order.class))).thenReturn(order);

		// Act
		orderService.markOrderPaid(orderId);

		// Assert
		assertEquals(OrderStatus.PAID, order.getStatus());
		verify(orderRepository, times(1)).findById(orderId);
		verify(orderRepository, times(1)).save(order);
	}
}