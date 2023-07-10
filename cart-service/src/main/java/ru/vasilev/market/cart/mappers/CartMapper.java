package ru.vasilev.market.cart.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vasilev.market.api.CartDto;
import ru.vasilev.market.cart.utils.Cart;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartMapper {

    private final CartItemMapper cartItemMapper;

    public CartDto mapCartToCartDto (Cart cart) {
        return CartDto.builder()
                .items(cart.getItems()
                        .stream()
                        .map(cartItemMapper::mapCartItemToCartItemDto)
                        .collect(Collectors.toList()))
                .totalPrice(cart.getTotalPrice())
                .build();
    }
}
