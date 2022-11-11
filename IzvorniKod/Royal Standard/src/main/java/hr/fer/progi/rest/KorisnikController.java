package hr.fer.progi.rest;

import hr.fer.progi.entity.Korisnik;
import hr.fer.progi.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/korisnik")
public class KorisnikController {
    @Autowired
    KorisnikService service;

    @GetMapping("")
    public List<Korisnik> korisnikList() {
        return service.listAll();
    }

    @PostMapping("")
    public Korisnik createKorisnik(@RequestBody Korisnik korisnik) {
        return service.createKorisnik(korisnik);
    }
}
