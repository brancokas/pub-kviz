package hr.fer.progi.royalstandard.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class KorisnikUlogaKey implements Serializable {

    @Column(name = "korisnik_id", nullable = false)
    private Long korisnikId;

    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
    }

    public Long getUlogaId() {
        return UlogaId;
    }

    public void setUlogaId(Long ulogaId) {
        UlogaId = ulogaId;
    }

    @Column(name = "uloga_id", nullable = false)
    private Long UlogaId;
}
