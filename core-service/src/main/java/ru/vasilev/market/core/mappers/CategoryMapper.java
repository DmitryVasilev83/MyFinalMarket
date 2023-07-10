package ru.vasilev.market.core.mappers;

import org.springframework.stereotype.Component;
import ru.vasilev.market.api.CategoryDto;
import ru.vasilev.market.core.entities.Category;

@Component
public class CategoryMapper {

    public CategoryDto mapCategoryToCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .title(category.getTitle())
                .build();
    }
}
