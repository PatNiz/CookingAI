package pl.niziolekp.app.cookingai.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.niziolekp.app.cookingai.dto.ProductDTO;
import pl.niziolekp.app.cookingai.model.Product;
import pl.niziolekp.app.cookingai.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductService(productRepository);
    }

    @Test
    public void testGetAllProducts() {
        // Given
        List<Product> mockProducts = Arrays.asList(new Product("Product 1"), new Product("Product 2"));
        when(productRepository.findAll()).thenReturn(mockProducts);

        // When
        List<ProductDTO> result = productService.getAllProducts();

        // Then
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).name());
        assertEquals("Product 2", result.get(1).name());
    }

}
