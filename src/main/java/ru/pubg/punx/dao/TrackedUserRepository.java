package ru.pubg.punx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pubg.punx.jdo.TrackedUser;

import java.util.Optional;

public interface TrackedUserRepository extends JpaRepository<TrackedUser, Long> {
    Optional<TrackedUser> findByUsername(String username);
}
