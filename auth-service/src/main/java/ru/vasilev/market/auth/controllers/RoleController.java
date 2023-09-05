package ru.vasilev.market.auth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.vasilev.market.auth.services.RoleService;
import ru.vasilev.market.api.ListResponse;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    @GetMapping
    public ListResponse<String> getAllUserRoles() {
        return new ListResponse<>(roleService.getAllRolesStr());
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/titles")
    public ListResponse<String> getAllRoleTitles() {
        return new ListResponse<>(roleService.getAllRoleTitles());
    }
}
