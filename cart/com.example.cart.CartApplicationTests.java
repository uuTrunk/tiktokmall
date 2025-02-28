
@Test
void testAddItem() throws Exception {
    mockMvc.perform(post("/api/cart/123/items")
                    .param("productId", "456")
                    .param("quantity", "2"))
            .andExpect(status().isCreated()); // 确保预期状态码是201
}
