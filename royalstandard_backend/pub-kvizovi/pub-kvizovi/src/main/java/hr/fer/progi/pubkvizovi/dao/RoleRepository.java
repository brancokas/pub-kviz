package hr.fer.progi.pubkvizovi.dao;

import hr.fer.progi.pubkvizovi.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
