package ru.vasilev.market.cart.mappers;

import org.springframework.stereotype.Component;
import ru.vasilev.market.api.CartItemDto;
import ru.vasilev.market.cart.utils.CartItem;

@Component
public class CartItemMapper {
    public CartItemDto mapCartItemToCartItemDto (CartItem cartItem) {
        return CartItemDto.builder()
                .productId(cartItem.getProductId())
                .productTitle(cartItem.getProductTitle())
                .quantity(cartItem.getQuantity())
                .pricePerProduct(cartItem.getPricePerProduct())
                .price(cartItem.getPrice())
                .build();
    }
}
