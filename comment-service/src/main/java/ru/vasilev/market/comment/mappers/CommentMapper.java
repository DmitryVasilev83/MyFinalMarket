package ru.vasilev.market.comment.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vasilev.market.api.CommentDto;
import ru.vasilev.market.comment.entities.Comment;

@Component
@RequiredArgsConstructor
public class CommentMapper {

    public CommentDto mapCommentToCommentDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .user(comment.getUsername())
                .product(comment.getProduct())
                .description(comment.getDescription())
                .estimation(comment.getEstimation())
                .build();
    }
}
