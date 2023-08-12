package ru.vasilev.market.auth.entities.services;

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

    public Role getAdminRole() {return roleRepository.findByName("ROLE_ADMIN").get(); }

    public List<String> getAllRolesStr() {
        return roleRepository.findAll().stream().map(Role::getName).toList();
    }

    public List<String> getAllRoleTitles() {return roleRepository.findAll().stream().map(Role::getTitle).toList(); }
}