package ait.shop.service;

import ait.shop.model.entity.Role;
import ait.shop.repository.RoleRepository;
import ait.shop.service.interfaces.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleUser() {
        // Получаем роль USER из базы данных
        return roleRepository.findByTitle("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Database doesn't contain ROLE_USER"));
    }
}