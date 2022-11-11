package hr.fer.progi.service.impl;

import hr.fer.progi.dao.KorisnikRepository;
import hr.fer.progi.entity.Korisnik;
import hr.fer.progi.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class KorisnikServiceJpa implements KorisnikService {
    @Autowired
    private KorisnikRepository repository;

    @Override
    public Korisnik createKorisnik(Korisnik korisnik) {
        Assert.notNull(korisnik, "Korisnik ne smije biti null.");
        Assert.isNull(korisnik.getId(), "Korisnikov ide mora biti null jer ga baza automatski generira.");
        return repository.save(korisnik);
    }

    @Override
    public List<Korisnik> listAll() {
        return repository.findAll();
    }
}
