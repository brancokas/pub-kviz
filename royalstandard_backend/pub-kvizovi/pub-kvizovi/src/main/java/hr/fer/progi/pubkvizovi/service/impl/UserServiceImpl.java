package hr.fer.progi.pubkvizovi.service.impl;

import hr.fer.progi.pubkvizovi.dao.UserRepository;
import hr.fer.progi.pubkvizovi.domain.Role;
import hr.fer.progi.pubkvizovi.domain.Team;
import hr.fer.progi.pubkvizovi.domain.User;
import hr.fer.progi.pubkvizovi.dto.UserRegisterDTO;
import hr.fer.progi.pubkvizovi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TeamService teamService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> listAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findByNickname(String nickname) {
        Assert.notNull(nickname, "Nickname must be given");
        return userRepo.findByNickname(nickname);
    }

    @Override
    public User createUser(UserRegisterDTO userDTO) {
        validateRegistration(userDTO);

        if (userRepo.existsByNickname(userDTO.getNickname()))
            throw new RequestDeniedException("User with nickname: " + userDTO.getNickname() + " already exists");

        if (userRepo.existsByEmail(userDTO.getEmail()))
            throw new RequestDeniedException("User with email: " + userDTO.getEmail() + " already exists");

        User user =
                new User(userDTO.getFirstName(),
                        userDTO.getLastName(),
                        userDTO.getEmail(),
                        userDTO.getImage(),
                        userDTO.getPhoneNumber(),
                        userDTO.getNickname()
                );

        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        String[] roles = userDTO.getRole().split(",");
        for (String r : roles) {
            Role role = roleService.findByName(r).orElseThrow(
                    () -> new RequestDeniedException("No role with name " + r)
            );
            user.getRoles().add(role);
        }

        Team team = null;
        if ((userDTO.getRole().equals("PLAYER") || userDTO.getRole().equals("PLAYER,QUIZMASTER")) && userDTO.isHasTeam()) {
            user.setKnowledgeArea(userDTO.getKnowledgeAreas());
            Optional<Team> teamOptional = teamService.findByName(userDTO.getTeamName());
            if (teamOptional.isEmpty())
                team = teamService.createTeam(userDTO.getTeamName());
            else
                team = teamService.addMember(teamOptional.get());
        }
        user.setMyTeam(team);

        return userRepo.save(user);
    }

    @Override
    public boolean validate(String givenPassword, String userPassword) {
        return passwordEncoder.matches(givenPassword, userPassword);
    }


    private void validateRegistration(UserRegisterDTO userDTO) {
        Assert.notNull(userDTO, "User object must be given");

        Assert.notNull(userDTO.getRole(), "Role must be given");
        Assert.notNull(userDTO.getFirstName(), "Name must be given");
        Assert.notNull(userDTO.getLastName(), "Surname must be given");
        Assert.notNull(userDTO.getNickname(), "Nickname must be given");
        Assert.notNull(userDTO.getEmail(), "Email must be given");
        Assert.notNull(userDTO.getPassword(), "Password must be given");

        String role = userDTO.getRole();
        if (role.equals("PLAYER") || role.equals("PLAYER,QUIZMASTER")) {
            Assert.notNull(userDTO.getKnowledgeAreas(), "Knowledge Areas must be given");
            Assert.notNull(userDTO.isHasTeam(), "HasTeam must be given");
            if (userDTO.isHasTeam())
                Assert.notNull(userDTO.getTeamName(), "Team name must be given");
        }

        if (userDTO.getPhoneNumber() != null)
            Assert.isTrue(userDTO.getPhoneNumber().matches("[0-9]+"), "Invalid phone number");

        validatePassword(userDTO.getPassword());
    }

    private void validatePassword(String password) {
        if (password.length() < 8)
            throw new IllegalArgumentException("Password is too short (minimum is 8 characters)!");

        boolean hasDigit = false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c))
                hasDigit = true;
            if (Character.isLowerCase(c))
                hasLowerCase = true;
            if (Character.isUpperCase(c))
                hasUpperCase = true;
        }

        if (!(hasDigit && hasLowerCase && hasUpperCase))
            throw new IllegalArgumentException("Password must contain at least 1 digit, 1 uppercase letter and 1 lowercase letter!");
    }
}
