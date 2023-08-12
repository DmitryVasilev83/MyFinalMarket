package ru.vasilev.market.auth.mappers;

import org.springframework.stereotype.Component;
import ru.vasilev.market.api.JwtRequest;
import ru.vasilev.market.api.RegistrationUserDto;
import ru.vasilev.market.api.UserDto;
import ru.vasilev.market.auth.repositories.UserRepository;
import ru.vasilev.market.auth.entities.User;

@Component
public class UserMapper {


    public UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRoles().get(0).getName())
                .access(user.getAccess())
                .build();
    }

    public JwtRequest mapRegistrationUserDtoToJwtRequest(RegistrationUserDto registrationUserDto) {
        return JwtRequest.builder()
                .password(registrationUserDto.getConfirmPassword())
                .username(registrationUserDto.getUsername())
                .build();
    }
}
