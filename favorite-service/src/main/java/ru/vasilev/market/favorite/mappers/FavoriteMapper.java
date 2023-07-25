package ru.vasilev.market.favorite.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vasilev.market.api.FavoriteDto;
import ru.vasilev.market.favorite.utils.Favorite;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FavoriteMapper {

    private final FavoriteItemMapper favoriteItemMapper;

    public FavoriteDto mapFavoriteToFavoriteDto(Favorite favorite) {
        return FavoriteDto.builder()
                .items(favorite.getItems()
                        .stream()
                        .map(favoriteItemMapper::mapFavoriteItemToFavoriteItemDto)
                        .collect(Collectors.toList()))
                .build();
    }
}
