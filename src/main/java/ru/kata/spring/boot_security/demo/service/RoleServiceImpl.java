package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.security_repository.RoleRepository;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Transactional
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Transactional
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Transactional
    public void update(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getByID(Long id) {
        return roleRepository.getById(id);
    }
}
