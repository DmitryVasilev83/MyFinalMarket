package ru.vasilev.market.core.mappers;

import org.springframework.stereotype.Component;
import ru.vasilev.market.api.ProductDto;
import ru.vasilev.market.core.entities.Product;

@Component
public class ProductMapper {

    public ProductDto mapProductToProductDto (Product product, Integer quantity) {
        return ProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .visible(product.isVisible())
                .categoryTitle(product.getCategory().getTitle())
                .quantityReservation(product.getQuantity() - quantity)
                .quantity(product.getQuantity())
                .imageId(product.getImageId())
                .build();
    }
}
