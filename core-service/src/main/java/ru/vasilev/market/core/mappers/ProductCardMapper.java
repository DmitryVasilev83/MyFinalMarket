package ru.vasilev.market.core.mappers;

import org.springframework.stereotype.Component;
import ru.vasilev.market.api.ProductCardDto;
import ru.vasilev.market.core.entities.Product;

@Component
public class ProductCardMapper {

    public ProductCardDto mapProductToProductCardDto(Product product) {
        return ProductCardDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .visible(product.isVisible())
                .categoryTitle(product.getCategory().getTitle())
                .description(product.getDescription())
                .build();
    }
}
