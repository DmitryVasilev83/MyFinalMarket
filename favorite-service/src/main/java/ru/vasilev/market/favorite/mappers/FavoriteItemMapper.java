package ru.vasilev.market.favorite.mappers;

import org.springframework.stereotype.Component;
import ru.vasilev.market.api.FavoriteItemDto;
import ru.vasilev.market.favorite.utils.FavoriteItem;

@Component
public class FavoriteItemMapper {
    public FavoriteItemDto mapFavoriteItemToFavoriteItemDto(FavoriteItem favoriteItem) {
        return FavoriteItemDto.builder()
                .productId(favoriteItem.getProductId())
                .productTitle(favoriteItem.getProductTitle())
                .price(favoriteItem.getPrice())
                .build();
    }
}
