package hr.fer.progi.royalstandard.dao;

import hr.fer.progi.royalstandard.domain.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    int countByNadimak(String username);

    Korisnik findByNadimak(String username);
}
