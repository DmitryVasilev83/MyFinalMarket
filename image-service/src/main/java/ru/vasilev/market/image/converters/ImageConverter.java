package ru.vasilev.market.image.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vasilev.market.api.ImageDto;
import ru.vasilev.market.image.models.Image;

@Component
@RequiredArgsConstructor
public class ImageConverter {
    public ImageDto entityToDto (Image image) {
        return ImageDto.builder()
                .id(image.getId())
                .title(image.getTitle())
                .image(image.getImage().getData())
                .build();
    }
}
