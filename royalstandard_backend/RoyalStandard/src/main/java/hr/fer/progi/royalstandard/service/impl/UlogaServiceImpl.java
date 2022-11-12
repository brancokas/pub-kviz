package hr.fer.progi.royalstandard.service.impl;

import hr.fer.progi.royalstandard.dao.UlogaRepository;
import hr.fer.progi.royalstandard.domain.Uloga;
import hr.fer.progi.royalstandard.service.UlogaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UlogaServiceImpl implements UlogaService {
    @Autowired
    private UlogaRepository repository;

    @Override
    public Long getUloga(String imeUloge) {
        Uloga uloga = repository.findByUlogaIme(imeUloge);
        if (uloga == null) {
            uloga = repository.save(new Uloga(imeUloge));
        }
        return uloga.getId();
    }
}
