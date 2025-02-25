package com.example.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CartApplicationTests {


	@Autowired
	private MockMvc mockMvc;

	@Test
	void testAddItem() throws Exception {
		mockMvc.perform(post("/api/cart/123/items")
						.param("productId", "456")
						.param("quantity", "2"))
				.andExpect(status().isCreated()); // 确保预期状态码是201
	}

	@Test
	void testGetCart() throws Exception {
		mockMvc.perform(get("/api/cart/123"))
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) jsonPath("$[0].productId").value(456));
	}

	@Test
	void testEmptyCart() throws Exception {
		mockMvc.perform(delete("/api/cart/123"))
				.andExpect(status().isNoContent());
	}

}
