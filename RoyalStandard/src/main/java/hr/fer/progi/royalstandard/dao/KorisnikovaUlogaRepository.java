package hr.fer.progi.royalstandard.dao;

import hr.fer.progi.royalstandard.domain.KorisnikUlogaKey;
import hr.fer.progi.royalstandard.domain.KorisnikovaUloga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikovaUlogaRepository extends JpaRepository<KorisnikovaUloga, KorisnikUlogaKey> {

    KorisnikovaUloga findByKljuc(KorisnikUlogaKey key);

}

