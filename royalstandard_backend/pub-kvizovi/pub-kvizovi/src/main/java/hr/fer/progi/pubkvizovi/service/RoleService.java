package hr.fer.progi.pubkvizovi.service;

import hr.fer.progi.pubkvizovi.domain.Role;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findByName(String name);
}
