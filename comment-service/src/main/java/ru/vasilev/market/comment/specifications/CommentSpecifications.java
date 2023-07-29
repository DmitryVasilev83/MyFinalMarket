package ru.vasilev.market.comment.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.vasilev.market.comment.entities.Comment;


public class CommentSpecifications {

    public static Specification<Comment> visibleLike() {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.isTrue(root.get("visible"));

    }

    public static Specification<Comment> productTitleEquals(String productTitle) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("product"), productTitle);
    }
}
