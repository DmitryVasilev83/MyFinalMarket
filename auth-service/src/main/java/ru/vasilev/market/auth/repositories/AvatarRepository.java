package ru.vasilev.market.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vasilev.market.auth.entities.Avatar;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
}
