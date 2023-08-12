package ru.vasilev.market.auth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.vasilev.market.api.AvatarPersonalAccount;
import ru.vasilev.market.auth.exceptions.AccessForbiddenException;
import ru.vasilev.market.auth.mappers.AvatarMapper;
import ru.vasilev.market.auth.entities.services.AvatarService;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/avatars")
@RequiredArgsConstructor
public class AvatarController {
    private final AvatarService avatarService;
    private final AvatarMapper avatarMapper;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping
    public ResponseEntity<AvatarPersonalAccount> getUserAvatar(@RequestHeader String username) {
        return ResponseEntity.ok(avatarMapper.map(avatarService.findByUsername(username)));
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping
    public ResponseEntity<AvatarPersonalAccount> updateUserAvatar(@RequestBody AvatarPersonalAccount avatar,
                                                                  @RequestHeader String username) {
        if (!Objects.equals(username, avatar.getUsername())) {
            throw new AccessForbiddenException("Запрещено изменять чужие персональные данные.");
        }
        return ResponseEntity.ok(avatarMapper.map(avatarService.update(avatarMapper.map(avatar))));
    }
}

