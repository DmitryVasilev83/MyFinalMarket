package ru.vasilev.market.auth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.vasilev.market.api.JwtRequest;
import ru.vasilev.market.api.JwtResponse;
import ru.vasilev.market.auth.services.UserService;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/authentication")
    public JwtResponse createAuthToken(@RequestBody JwtRequest authRequest) {
        userService.auth(authRequest);
        userService.userFilter(authRequest.getUsername());
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        return JwtResponse.builder()
                .token(userService.getToken(userDetails))
                .visibleAdministrationButton(userService.getAccessAdmin(authRequest.getUsername()))
                .visibleUserPanelButton(userService.getAccessUserPanel(authRequest.getUsername()))
                .visibleProductPanelButton(userService.getAccessProductPanel(authRequest.getUsername()))
                .visibleEditRoleButton(userService.getAccessEditRole(authRequest.getUsername()))
                .build();
    }

}
