package ru.vasilev.market.auth.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vasilev.market.auth.repositories.RoleRepository;
import ru.vasilev.market.auth.entities.Role;
import ru.vasilev.market.auth.exceptions.ResourceNotFoundException;

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

    public List<String> getAllRoleTitles() {
        return roleRepository.findAll().stream().map(Role::getTitle)
            .filter((title) -> !title.equals("генеральный директор")).toList();
    }

    public Role getRoleByName(String nameRole) { return roleRepository.findByName(nameRole).orElseThrow(
            () -> new ResourceNotFoundException("Роль " + nameRole + " не найденa.")
    );}

    public Role getRoleByTitle(String title) {return roleRepository.findByTitle(title).orElseThrow(
            () -> new ResourceNotFoundException("Роль " + title + " не найденa.")
    );}
}