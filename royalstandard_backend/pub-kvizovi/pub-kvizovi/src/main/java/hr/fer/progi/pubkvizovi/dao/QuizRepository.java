package hr.fer.progi.pubkvizovi.dao;

import hr.fer.progi.pubkvizovi.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
