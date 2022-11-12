package hr.fer.progi.royalstandard.service.impl;

import hr.fer.progi.royalstandard.dao.KorisnikovaUlogaRepository;
import hr.fer.progi.royalstandard.domain.KorisnikUlogaKey;
import hr.fer.progi.royalstandard.domain.KorisnikovaUloga;
import hr.fer.progi.royalstandard.service.KorisnikovaUlogaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikovaUlogaServiceImpl implements KorisnikovaUlogaService {
    @Autowired
    private KorisnikovaUlogaRepository repository;

    @Override
    public KorisnikovaUloga dodajRolu(Long korisnikId, Long ulogaId) {
        KorisnikUlogaKey key = new KorisnikUlogaKey();
        key.setKorisnikId(korisnikId);
        key.setUlogaId(ulogaId);
        KorisnikovaUloga korisnikovaUloga = repository.findByKljuc(key);
        if (korisnikovaUloga != null)
            throw new IllegalArgumentException(String.format("User %d s rolom %d je vec dodan", korisnikId, ulogaId));
        return repository.save(new KorisnikovaUloga(key));
    }
}
