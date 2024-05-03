package org.example.spring_conference.service;

import org.example.spring_conference.model.Role;
import org.example.spring_conference.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> saveAll(List<Role> roles) {
        return roleRepository.saveAll(roles);
    }
}
