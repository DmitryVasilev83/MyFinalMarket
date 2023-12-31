package ru.vasilev.market.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CommentDto {
    private Long id;
    private String user;
    private String product;
    private String description;
    private Integer estimation;
}
