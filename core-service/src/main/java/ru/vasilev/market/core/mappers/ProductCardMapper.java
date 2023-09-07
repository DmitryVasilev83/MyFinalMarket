package ru.vasilev.market.core.mappers;

import org.springframework.stereotype.Component;
import ru.vasilev.market.api.ProductCardDto;
import ru.vasilev.market.core.entities.Product;

@Component
public class ProductCardMapper {

    public ProductCardDto mapProductToProductCardDto(Product product, Integer quantity) {
        return ProductCardDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .visible(product.isVisible())
                .categoryTitle(product.getCategory().getTitle())
                .quantityReservation(product.getQuantity() - quantity)
                .quantity(product.getQuantity())
                .description(product.getDescription())
                .imageId(product.getImageId())
                .build();
    }
}
