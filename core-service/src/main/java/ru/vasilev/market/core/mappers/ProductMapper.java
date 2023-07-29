package ru.vasilev.market.core.mappers;

import org.springframework.stereotype.Component;
import ru.vasilev.market.api.ProductDto;
import ru.vasilev.market.core.entities.Product;

@Component
public class ProductMapper {

    public ProductDto mapProductToProductDto (Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .visible(product.isVisible())
                .categoryTitle(product.getCategory().getTitle())
                .quantity(product.getQuantity())
                .build();
    }
}
