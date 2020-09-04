package com.pavelnazaro.market.services;

import com.pavelnazaro.market.entities.Role;
import com.pavelnazaro.market.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {
    private RolesRepository rolesRepository;

    @Autowired
    public void setRolesRepository(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public Role findByName(String name) {
        return rolesRepository.findOneByName(name);
    }
}
