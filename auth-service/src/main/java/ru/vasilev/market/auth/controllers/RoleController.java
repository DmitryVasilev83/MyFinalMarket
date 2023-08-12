package ru.vasilev.market.auth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.vasilev.market.auth.entities.services.RoleService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public List<String> getAllUserRoles() {
        return roleService.getAllRolesStr();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/titles")
    public List<String> getAllRoleTitles() {
        return roleService.getAllRoleTitles();
    }
}
