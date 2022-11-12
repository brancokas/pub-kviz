package hr.fer.progi.royalstandard.dao;

import hr.fer.progi.royalstandard.domain.Uloga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UlogaRepository extends JpaRepository<Uloga, Long> {
    Uloga findByUlogaIme(String UlogaIme);
}
