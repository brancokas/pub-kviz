package hr.fer.progi.royalstandard.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "korisnik_uloga")
public class KorisnikovaUloga {
    @EmbeddedId
    private KorisnikUlogaKey kljuc;

    public KorisnikUlogaKey getKljuc() {
        return kljuc;
    }

    public void setKljuc(KorisnikUlogaKey kljuc) {
        this.kljuc = kljuc;
    }

    public KorisnikovaUloga(KorisnikUlogaKey kljuc) {
        this.kljuc = kljuc;
    }

    public KorisnikovaUloga() {
    }
}
