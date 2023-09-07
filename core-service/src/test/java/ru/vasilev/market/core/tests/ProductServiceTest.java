package ru.vasilev.market.core.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.vasilev.market.api.ProductCardDto;
import ru.vasilev.market.core.repositories.ProductRepository;
import ru.vasilev.market.core.entities.Category;
import ru.vasilev.market.core.entities.Product;
import ru.vasilev.market.core.services.CategoryService;
import ru.vasilev.market.core.services.ProductService;
import ru.vasilev.market.core.integrations.CartServiceIntegration;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest(classes = ProductService.class)
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private CategoryService categoryService;

    @MockBean
    private CartServiceIntegration cartServiceIntegration;

    @Test
    public void createOrderTest() {
        ProductCardDto productCardDto = ProductCardDto.builder()
                .price(new BigDecimal(20))
                .title("Milk")
                .categoryTitle("other")
                .quantityReservation(1)
                .quantity(3)
                .id(50L)
                .build();

        Category category = Category.builder()
                .id(4L)
                .title("Other")
                .build();

        Mockito.doReturn(Optional.of(category)).when(categoryService).findByTitle("other");
        Mockito.doReturn(false).when(productRepository).existsByTitle(productCardDto.getTitle());

        Product product = productService.createNewProduct(productCardDto);
        Assertions.assertEquals(product.getTitle(), "Milk");
        Mockito.verify(productRepository, Mockito.times(1)).save(ArgumentMatchers.any());
    }
}
