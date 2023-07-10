package ru.vasilev.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vasilev.market.api.CategoryDto;
import ru.vasilev.market.core.repositories.CategoryRepository;
import ru.vasilev.market.core.entities.Category;
import ru.vasilev.market.core.mappers.CategoryMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<CategoryDto> getAllCategoriesDto() {
        return getAllCategories().stream().map(categoryMapper::mapCategoryToCategoryDto)
                .collect(Collectors.toList());
    }

    public List<String> getTitleCategory() {
        return getAllCategories().stream().map(Category::getTitle).collect(Collectors.toList());
    }
}
