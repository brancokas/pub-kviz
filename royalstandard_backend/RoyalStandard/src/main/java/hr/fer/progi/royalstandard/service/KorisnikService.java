package hr.fer.progi.royalstandard.service;

import hr.fer.progi.royalstandard.domain.Korisnik;

import java.util.List;

public interface KorisnikService {
    List<Korisnik> listAll();

    Korisnik createKorisnik(Korisnik korisnik);

    Korisnik getKorisnik(String username);

    boolean validate(String givenPassword, String userPassword);
}
