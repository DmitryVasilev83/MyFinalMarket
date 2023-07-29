package ru.vasilev.market.comment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vasilev.market.comment.entities.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {
    boolean existsByUsernameAndProduct(String username, String product);

    Comment getCommentByUsernameAndProduct(String username, String product);

    @Query(nativeQuery = true, value = "SELECT AVG(estimation) FROM comments where product = :productTitle")
    Double getEstimation(@Param("productTitle") String productTitle);

}
