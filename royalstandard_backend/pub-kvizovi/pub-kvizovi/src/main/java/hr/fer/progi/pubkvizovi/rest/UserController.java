package hr.fer.progi.pubkvizovi.rest;

import hr.fer.progi.pubkvizovi.domain.User;
import hr.fer.progi.pubkvizovi.dto.UserLoginDTO;
import hr.fer.progi.pubkvizovi.dto.UserRegisterDTO;
import hr.fer.progi.pubkvizovi.service.RequestDeniedException;
import hr.fer.progi.pubkvizovi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> listUsers() {
        return userService.listAll();
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody UserRegisterDTO userDTO) {
        User user = userService.createUser(userDTO);
        return ResponseEntity.created(URI.create("/users/" + user.getId())).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody UserLoginDTO userDTO) {
        User user = userService.findByNickname(userDTO.getNickname()).orElseThrow(
                () -> new RequestDeniedException("Invalid nickname or password")
        );
        boolean validPassword = userService.validate(userDTO.getPassword(), user.getPassword());
        if (!validPassword)
            throw new RequestDeniedException("Invalid nickname or password");
        return ResponseEntity.ok().body(user);
    }

//    @GetMapping("/proba1")
//    @PreAuthorize("hasRole('ROLE_PLAYER')")
//    public String proba1() {
//        return "abc!";
//    }
//
//    @GetMapping("/proba2")
//    @Secured({"ROLE_QUIZMASTER"})
//    public String proba2() {
//        return "123!";
//    }
//
//    @GetMapping("/proba3")
//    @Secured({"ROLE_ADMIN"})
//    public String proba3() {
//        return "ABC!";
//    }
//
//    @GetMapping("/proba4")
//    @Secured({"ROLE_PLAYER", "ROLE_QUIZMASTER"})
//    public String proba4() {
//        return "987!";
//    }

}