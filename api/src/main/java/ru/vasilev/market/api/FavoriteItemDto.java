package ru.vasilev.market.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoriteItemDto {
    private Long productId;
    private String productTitle;
    private BigDecimal price;
}
