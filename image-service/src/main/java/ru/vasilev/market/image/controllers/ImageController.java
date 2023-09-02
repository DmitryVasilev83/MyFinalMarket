package ru.vasilev.market.image.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.vasilev.market.api.ImageDto;
import ru.vasilev.market.image.converters.ImageConverter;
import ru.vasilev.market.image.services.ImageService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;
    private  final ImageConverter imageConverter;

    @GetMapping("/{id}")
    public ResponseEntity<ImageDto> getImage(@PathVariable String id){
        return ResponseEntity.ok(imageConverter.entityToDto(imageService.getImage(id)
                        .orElseThrow(() -> new RuntimeException("Изображение с id: '" + id + "' не найдено!"))));

    }

    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER', 'ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadImage(@RequestBody ImageDto image, Principal principal) {
        imageService.uploadImage(image, principal);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER', 'ROLE_ADMIN')")
    @DeleteMapping("/{id}/products/{product-id}")
    public void deleteImage(@PathVariable String id, @PathVariable (name = "product-id") Long productId, Principal principal) {
        imageService.deleteImage(id, productId, principal);
    }
}
