package ru.vasilev.market.auth.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vasilev.market.api.AvatarPersonalAccount;
import ru.vasilev.market.auth.entities.Avatar;
import ru.vasilev.market.auth.entities.User;
import ru.vasilev.market.auth.entities.services.UserService;

@Component
@RequiredArgsConstructor
public class AvatarMapper {

    private final UserService userService;

    public AvatarPersonalAccount map(Avatar avatar) {
        return AvatarPersonalAccount.builder()
                .username(avatar.getUser().getUsername())
                .avatar(avatar.getAvatar())
                .build();
    }

    public Avatar map(AvatarPersonalAccount avatar) {
        User user = userService.getByName(avatar.getUsername());
        return Avatar.builder()
                .id(user.getId())
                .avatar(avatar.getAvatar())
                .user(user)
                .build();
    }
}
