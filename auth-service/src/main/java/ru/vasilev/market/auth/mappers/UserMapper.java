package ru.vasilev.market.auth.mappers;

import org.springframework.stereotype.Component;
import ru.vasilev.market.api.JwtRequest;
import ru.vasilev.market.api.RegistrationUserDto;
import ru.vasilev.market.api.UserDto;
import ru.vasilev.market.auth.repositories.UserRepository;
import ru.vasilev.market.auth.entities.User;

@Component
public class UserMapper {
    private final UserRepository userRepository;

    public UserMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto mapUserToUserDto(User user) {
        UserDto userdto = UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRoles().get(0).getName())
                .access(user.getAccess())
                .build();
        return userdto;
    }

    public JwtRequest mapRegistrationUserDtoToJwtRequest(RegistrationUserDto registrationUserDto) {
        JwtRequest jwtRequest = JwtRequest.builder()
                .password(registrationUserDto.getConfirmPassword())
                .username(registrationUserDto.getUsername())
                .build();
        return jwtRequest;
    }
}
