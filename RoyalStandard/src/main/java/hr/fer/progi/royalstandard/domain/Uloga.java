package hr.fer.progi.royalstandard.domain;

import javax.persistence.*;

@Entity
public class Uloga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uloga_id")
    private Long id;

    @Column(name = "uloga_ime")
    private String ulogaIme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUlogaIme() {
        return ulogaIme;
    }

    public void setUlogaIme(String ulogaIme) {
        this.ulogaIme = ulogaIme;
    }

    public Uloga(String ulogaIme) {
        this.ulogaIme = ulogaIme;
    }

    public Uloga() {
    }

    @Override
    public String toString() {
        return "Uloga{" +
                "id=" + id +
                ", ulogaIme='" + ulogaIme + '\'' +
                '}';
    }
}
