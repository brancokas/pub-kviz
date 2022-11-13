package hr.fer.progi.pubkvizovi.service;

import hr.fer.progi.pubkvizovi.domain.User;
import hr.fer.progi.pubkvizovi.dto.UserRegisterDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> listAll();

    Optional<User> findByNickname(String nickname);

    User createUser(UserRegisterDTO userDTO);

    boolean validate(String givenPassword, String userPassword);
}
