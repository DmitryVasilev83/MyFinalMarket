package ru.vasilev.market.auth.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vasilev.market.api.AvatarPersonalAccount;
import ru.vasilev.market.auth.entities.Avatar;
import ru.vasilev.market.auth.entities.User;

@Component
@RequiredArgsConstructor
public class AvatarMapper {

    public AvatarPersonalAccount map(Avatar avatar) {
        return AvatarPersonalAccount.builder()
                .avatar(avatar.getAvatar())
                .build();
    }

    public Avatar map(AvatarPersonalAccount avatar, User user) {
        return Avatar.builder()
                .id(user.getId())
                .avatar(avatar.getAvatar())
                .user(user)
                .build();
    }
}
