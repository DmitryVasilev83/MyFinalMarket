package ru.vasilev.market.auth.mappers;

import org.springframework.stereotype.Component;
import ru.vasilev.market.api.UserDto;
import ru.vasilev.market.auth.entities.Role;
import ru.vasilev.market.auth.entities.User;

@Component
public class UserMapper {


    public UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .rolesTitle(user.getRoles().stream().map(Role::getTitle).toList())
                .access(user.getAccess())
                .build();
    }
}
