package ru.vasilev.market.auth.entities.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasilev.market.auth.entities.Avatar;
import ru.vasilev.market.auth.exceptions.ResourceNotFoundException;
import ru.vasilev.market.auth.repositories.AvatarRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvatarService {

    private final AvatarRepository avatarRepository;
    private final UserService userService;

    public Optional<Avatar> findById(Long id) {
        return avatarRepository.findById(id);
    }

    public Avatar findByUsername(String username) {
        final String message = "Аватар пользователя " + username + " не найден.";
        Avatar avatar = findById(userService.getByName(username).getId()).orElseThrow(
                () -> new ResourceNotFoundException(message)
        );
        if (avatar.getAvatar() == null) {
            throw new ResourceNotFoundException(message);
        }
        return avatar;
    }

    @Transactional
    public Avatar update(Avatar avatar) {
        return avatarRepository.save(avatar);
    }
}
