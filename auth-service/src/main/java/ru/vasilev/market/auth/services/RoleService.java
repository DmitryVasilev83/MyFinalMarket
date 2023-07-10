package ru.vasilev.market.auth.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vasilev.market.auth.repositories.RoleRepository;
import ru.vasilev.market.auth.entities.Role;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public List<String> getAllRolesStr() {
        return roleRepository.findAll().stream().map(Role::getName).toList();
    }
}