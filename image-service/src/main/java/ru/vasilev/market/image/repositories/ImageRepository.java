package ru.vasilev.market.image.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.vasilev.market.image.models.Image;

public interface ImageRepository extends MongoRepository<Image, String> {
}
