package hr.fer.progi.royalstandard.service.impl;

import hr.fer.progi.royalstandard.dao.KorisnikRepository;
import hr.fer.progi.royalstandard.domain.Korisnik;
import hr.fer.progi.royalstandard.service.KorisnikService;
import hr.fer.progi.royalstandard.service.RequestDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService {
    @Autowired
    private KorisnikRepository repository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private Korisnik currentUser;

    @Override
    public Korisnik getCurrentUser() {
        return currentUser;
    }

    @Override
    public Korisnik logoutUser() {
        return currentUser = null;
    }

    @Override
    public Korisnik createKorisnik(Korisnik korisnik) {
        if (repository.countByNadimak(korisnik.getNadimak()) > 0)
            throw new RequestDeniedException(String.format(
                    "Nadimak %s je vec zauzet", korisnik.getNadimak()));


        Assert.notNull(korisnik, "Korisnik ne smije biti null vrijednost.");
        Assert.isNull(korisnik.getId(), "Id mora biti nula jer ce se sam generirati");
        Assert.isTrue(korisnik.getBrojTelefona() == null ||
                        korisnik.getBrojTelefona().matches("[0-9]+"),
                "Broj telefona moraju biti znamenke");

        String encodedPassword = passwordEncoder.encode(korisnik.getPassword());
        korisnik.setPassword(encodedPassword);
        currentUser = repository.save(korisnik);
        return currentUser;
    }

    @Override
    public Korisnik getKorisnik(String username) {
        return repository.findByNadimak(username);
    }

    @Override
    public boolean validate(String givenPassword, String userPassword) {
        return passwordEncoder.matches(givenPassword, userPassword);
    }
}
