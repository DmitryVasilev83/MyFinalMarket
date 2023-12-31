package ru.vasilev.market.core.mappers;

import org.springframework.stereotype.Component;
import ru.vasilev.market.api.OrderItemDto;
import ru.vasilev.market.core.entities.OrderItem;

@Component
public class OrderItemMapper {

    public OrderItemDto mapOrderItemToOrderItemDto (OrderItem orderItem) {
        return OrderItemDto.builder()
                .productId(orderItem.getProduct().getId())
                .productTitle(orderItem.getProduct().getTitle())
                .quantity(orderItem.getQuantity())
                .pricePerProduct(orderItem.getPricePerProduct())
                .price(orderItem.getPrice())
                .build();
    }
}
