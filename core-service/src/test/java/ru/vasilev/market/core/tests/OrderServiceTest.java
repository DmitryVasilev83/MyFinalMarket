package ru.vasilev.market.core.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.vasilev.market.api.CartDto;
import ru.vasilev.market.api.CartItemDto;
import ru.vasilev.market.core.entities.Category;
import ru.vasilev.market.core.entities.Order;
import ru.vasilev.market.core.entities.Product;
import ru.vasilev.market.core.integrations.CartServiceIntegration;
import ru.vasilev.market.core.repositories.OrderRepository;
import ru.vasilev.market.core.services.OrderService;
import ru.vasilev.market.core.services.ProductService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.security.Principal;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = OrderService.class)
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @MockBean
    private CartServiceIntegration cartServiceIntegration;

    @MockBean
    private ProductService productService;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    public void createOrderTest() {
        CartItemDto cartItemDto = CartItemDto.builder()
                .productTitle("Juice")
                .pricePerProduct(new BigDecimal(120))
                .quantity(2)
                .price(new BigDecimal(240))
                .productId(1922L)
                .build();
        CartDto cartDto = CartDto.builder()
                .totalPrice(new BigDecimal(240))
                .items(List.of(cartItemDto))
                .build();

        Principal principal = new Principal() {
            @Override
            public String getName() {
                return "Bob";
            }

            @Override
            public String toString() {
                List<String> roles = new ArrayList<>();
                roles.add("ROLE_USER");
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("Bob",
                        null, roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
                return token.toString();
            }
        };

        Mockito.doReturn(cartDto).when(cartServiceIntegration).getCurrentUserCart(principal.getName(), principal.toString());

        Category category = Category.builder()
                .id(4L)
                .title("Other")
                .build();

        Product product = Product.builder()
                .id(1922L)
                .price(new BigDecimal(120))
                .title("Juice")
                .category(category)
                .build();

        Mockito.doReturn(Optional.of(product)).when(productService).findById(1922L);
        Order order = orderService.createNewOrder(principal.getName(), principal.toString());
        Assertions.assertEquals(order.getTotalPrice(), new BigDecimal(240));
        Mockito.verify(orderRepository, Mockito.times(1)).save(ArgumentMatchers.any());
    }
}
