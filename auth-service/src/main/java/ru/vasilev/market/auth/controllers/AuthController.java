package ru.vasilev.market.auth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.vasilev.market.api.JwtRequest;
import ru.vasilev.market.api.JwtResponse;
import ru.vasilev.market.api.RegistrationUserDto;
import ru.vasilev.market.auth.mappers.UserMapper;
import ru.vasilev.market.auth.services.UserService;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        userService.auth(authRequest);
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        JwtResponse jwtResponse = JwtResponse.builder()
                .token(userService.getToken(userDetails))
                .visibleAdministrationButton(userService.getAccessAdmin(authRequest.getUsername()))
                .visibleUserPanelButton(userService.getAccessUserPanel(authRequest.getUsername()))
                .visibleProductPanelButton(userService.getAccessProductPanel(authRequest.getUsername()))
                .visibleEditRoleButton(userService.getAccessEditRole(authRequest.getUsername()))
                .build();
        userService.userFilter(authRequest.getUsername());
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<?> createAuthToken(@RequestBody RegistrationUserDto registrationUserDto) {
        userService.reg(registrationUserDto);
        UserDetails userDetails = userService.loadUserByUsername(registrationUserDto.getUsername());
        JwtResponse jwtResponse = JwtResponse.builder()
                .token(userService.getToken(userDetails))
                .build();
        return ResponseEntity.ok(jwtResponse);
    }


}
