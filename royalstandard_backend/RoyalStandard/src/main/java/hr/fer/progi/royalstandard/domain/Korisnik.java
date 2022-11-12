package hr.fer.progi.royalstandard.domain;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "korisnik_id")
    private Long id;

    @NotNull
    private String ime;

    @NotNull
    private String prezime;

    @Column(name = "email_adresa")
    private String email;

    @Column(name = "broj_telefona")
    private String brojTelefona;

    @NotNull
    private String password;

    @Column(name = "podrucja_znanja")
    private String podrucjaZnanja;

    @Column(unique = true, nullable = false)
    @NotNull
    private String nadimak;

    @Column(name = "prosj_broj_ekipa")
    private Integer prosjBrEkipa;

    private boolean blokiran;

    @Column(name = "ekipa_id")
    @JoinColumn(name = "Ekipa", referencedColumnName = "ekipa_id")
    private Long ekipaId;

    public Korisnik(String ime, String prezime, String email, String brojTelefona, String password, String nadimak) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.password = password;
        this.nadimak = nadimak;
    }

    public Korisnik() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPodrucjaZnanja() {
        return podrucjaZnanja;
    }

    public void setPodrucjaZnanja(String podrucjaZnanja) {
        this.podrucjaZnanja = podrucjaZnanja;
    }

    public String getNadimak() {
        return nadimak;
    }

    public void setNadimak(String nadimak) {
        this.nadimak = nadimak;
    }

    public Integer getProsjBrEkipa() {
        return prosjBrEkipa;
    }

    public void setProsjBrEkipa(Integer prosjBrEkipa) {
        this.prosjBrEkipa = prosjBrEkipa;
    }

    public boolean isBlokiran() {
        return blokiran;
    }

    public void setBlokiran(boolean blokiran) {
        this.blokiran = blokiran;
    }

    public Long getEkipaId() {
        return ekipaId;
    }

    public void setEkipaId(Long ekipaId) {
        this.ekipaId = ekipaId;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", brojTelefona='" + brojTelefona + '\'' +
                ", password='" + password + '\'' +
                ", podrucjaZnanja='" + podrucjaZnanja + '\'' +
                ", nadimak='" + nadimak + '\'' +
                ", prosjBrEkipa=" + prosjBrEkipa +
                ", blokiran=" + blokiran +
                ", ekipaId=" + ekipaId +
                '}';
    }
}

