package hr.fer.progi.royalstandard.rest;

import hr.fer.progi.royalstandard.domain.Korisnik;
import hr.fer.progi.royalstandard.service.KorisnikService;
import hr.fer.progi.royalstandard.service.KorisnikovaUlogaService;
import hr.fer.progi.royalstandard.service.RequestDeniedException;
import hr.fer.progi.royalstandard.service.UlogaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private KorisnikovaUlogaService korisnikovaUlogaService;

    @Autowired
    private UlogaService ulogaService;

    @GetMapping("/register")
    public Korisnik listKorisnici() {
        return korisnikService.getCurrentUser();
    }

    @PostMapping(value = "/register")
    public Korisnik registerUser(@RequestBody CreateKorisnik korisnik) {
        Korisnik noviKorisnik = new Korisnik(korisnik.getName(), korisnik.getSurname(),
                korisnik.getEmail(),korisnik.getPhone(),
                korisnik.getPassword(), korisnik.getUsername());

        noviKorisnik =  korisnikService.createKorisnik(noviKorisnik);
        Long ulogaId = ulogaService.getUloga(korisnik.getRole());
        korisnikovaUlogaService.dodajRolu(noviKorisnik.getId(), ulogaId);
        return noviKorisnik;
    }

    @PostMapping(value = "/login")
    public Korisnik loginUser(@RequestBody UserLogin userLogin) {
        Korisnik korisnik = korisnikService.getKorisnik(userLogin.getUsername());
        System.out.println(userLogin + " \n " + korisnik);
        if (korisnik == null ||
                !korisnikService.validate(userLogin.getPassword(), korisnik.getPassword()))
            throw new RequestDeniedException("Korisnik s danim usernamom i lozinkom ne postoji");

        return korisnik;
    }

    @GetMapping("/logout")
    public Korisnik logoutUser() {
        return korisnikService.logoutUser();
    }

}
