package ru.vasilev.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasilev.market.api.CartDto;
import ru.vasilev.market.core.exceptions.ResourceNotFoundException;
import ru.vasilev.market.core.integrations.CartServiceIntegration;
import ru.vasilev.market.core.repositories.OrderRepository;
import ru.vasilev.market.core.entities.Order;
import ru.vasilev.market.core.entities.OrderItem;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CartServiceIntegration cartServiceIntegration;
    private final OrderRepository orderRepository;
    private final ProductService productService;

    @Transactional
    public Order createNewOrder(String username, String tokenSecurity) {
        CartDto cart = cartServiceIntegration.getCurrentUserCart(username, tokenSecurity);
        if (cart.getItems().isEmpty()) {
            throw new IllegalStateException("Нельзя оформить заказ для пустой корзины");
        }
        Order order = new Order();
        order.setTotalPrice(cart.getTotalPrice());
        order.setUsername(username);
        order.setItems(new ArrayList<>());
        cart.getItems().forEach(ci -> {
            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setPrice(ci.getPrice());
            oi.setQuantity(ci.getQuantity());
            oi.setPricePerProduct(ci.getPricePerProduct());
            oi.setProduct(productService.findById(ci.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product not found")));
            order.getItems().add(oi);
        });
        orderRepository.save(order);
        cartServiceIntegration.clearCart(username, tokenSecurity);
        return order;
    }

    public List<Order> findUserOrders(String username) {
        return orderRepository.findAllByUsername(username);
    }

    public void deleteOrders(String username) {
        orderRepository.deleteAll(orderRepository.findAllByUsername(username));
    }
}
