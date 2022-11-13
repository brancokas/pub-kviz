package hr.fer.progi.pubkvizovi.rest;

import hr.fer.progi.pubkvizovi.domain.Team;
import hr.fer.progi.pubkvizovi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("")
    public List<Team> listTeams() {
        return teamService.listAll();
    }
}
