package hr.fer.progi.pubkvizovi.service;

import hr.fer.progi.pubkvizovi.domain.Team;
import hr.fer.progi.pubkvizovi.domain.User;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    List<Team> listAll();

    Optional<Team> findByName(String name);

    Team createTeam(String name);

    Team addMember(Team team);

}
