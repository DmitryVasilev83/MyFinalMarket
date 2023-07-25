package ru.vasilev.market.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FavoriteDto {
    private List<FavoriteItemDto> items;
}
