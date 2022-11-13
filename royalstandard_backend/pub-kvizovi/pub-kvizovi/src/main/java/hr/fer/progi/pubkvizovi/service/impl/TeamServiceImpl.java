package hr.fer.progi.pubkvizovi.service.impl;

import hr.fer.progi.pubkvizovi.dao.TeamRepository;
import hr.fer.progi.pubkvizovi.domain.Team;
import hr.fer.progi.pubkvizovi.domain.User;
import hr.fer.progi.pubkvizovi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepo;

    @Value("${pubkvizovi.team.maxNumOfMembers}")
    private int maxNumOfMembers;

    @Override
    public List<Team> listAll() {
        return teamRepo.findAll();
    }

    @Override
    public Optional<Team> findByName(String name) {
        Assert.notNull(name, "Team name must be given");
        return teamRepo.findByName(name);
    }

    @Override
    public Team createTeam(String name) {
        Team team = new Team(name);
        return teamRepo.save(team);
    }

    @Override
    public Team addMember(Team team) {
        Integer numOfMembers = team.getNumOfMembers();
        Assert.isTrue(numOfMembers < maxNumOfMembers, "This team is full");
        team.setNumOfMembers(numOfMembers + 1);
        return teamRepo.save(team);
    }

}
