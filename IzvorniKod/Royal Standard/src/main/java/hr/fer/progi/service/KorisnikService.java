package hr.fer.progi.service;

import hr.fer.progi.entity.Korisnik;

import java.util.List;

public interface KorisnikService {
    List<Korisnik> listAll();

    Korisnik createKorisnik(Korisnik korisnik);
}
