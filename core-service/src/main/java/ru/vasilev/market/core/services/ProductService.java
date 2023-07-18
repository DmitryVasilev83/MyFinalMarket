package ru.vasilev.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasilev.market.api.ProductCardDto;
import ru.vasilev.market.core.entities.Category;
import ru.vasilev.market.core.exceptions.FieldsNotNullException;
import ru.vasilev.market.core.exceptions.ResourceNotFoundException;
import ru.vasilev.market.core.exceptions.TheProductExistsException;
import ru.vasilev.market.core.repositories.ProductRepository;
import ru.vasilev.market.core.entities.Product;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public Page<Product> findAll(int page, int pageSize, Specification<Product> specification) {
        Sort sort = Sort.by("title");
        return productRepository.findAll(specification, PageRequest.of(page, pageSize, sort));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void updateProduct(ProductCardDto productCardDto) {
        Product product = productRepository.getById(productCardDto.getId());
        if (productCardDto.getTitle() != null) {
            product.setTitle(productCardDto.getTitle());
        }
        if (productCardDto.getPrice() != null) {
            product.setPrice(productCardDto.getPrice());
        }
        if (productCardDto.getCategoryTitle() != null) {
            Category category = categoryService.findByTitle(productCardDto.getCategoryTitle())
                    .orElseThrow(() -> new ResourceNotFoundException("Категория не найдена"));
            product.setCategory(category);
        }
        productRepository.save(product);
    }

    public Product createNewProduct(ProductCardDto productCardDto) {
        if (productCardDto.getTitle() == null || productCardDto.getCategoryTitle() == null
                || productCardDto.getPrice() == null) {
            throw new FieldsNotNullException("Все поля формы должны быть заполнены");
        }
        Product product = new Product();
        product.setTitle(productCardDto.getTitle());
        product.setPrice(productCardDto.getPrice());
        product.setVisible(true);
        product.setCategory(categoryService.findByTitle(productCardDto.getCategoryTitle()).orElseThrow(
                () -> new ResourceNotFoundException("Категория с названием: " +
                        productCardDto.getCategoryTitle() + " не найдена")));
        product.setDescription((productCardDto.getDescription()));
        if (productRepository.existsByTitle(productCardDto.getTitle())) {
            throw new TheProductExistsException("Такой продукт уже существует");
        }
        productRepository.save(product);
        return product;
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void updateVisible(Long id, Boolean visible) {
        Product byId = productRepository.getById(id);
        byId.setVisible(visible);
        productRepository.save(byId);
    }
}
