package hr.fer.progi.pubkvizovi.dao;

import hr.fer.progi.pubkvizovi.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
