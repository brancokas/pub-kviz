package hr.fer.progi.pubkvizovi.service.impl;

import hr.fer.progi.pubkvizovi.dao.RoleRepository;
import hr.fer.progi.pubkvizovi.domain.Role;
import hr.fer.progi.pubkvizovi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleRepository roleRepo;


    @Override
    public Optional<Role> findByName(String name) {
        return roleRepo.findByName(name);
    }
}
