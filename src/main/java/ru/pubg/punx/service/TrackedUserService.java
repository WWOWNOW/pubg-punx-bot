package ru.pubg.punx.service;

import org.springframework.stereotype.Service;
import ru.pubg.punx.dao.TrackedUserRepository;
import ru.pubg.punx.jdo.TrackedUser;

import java.util.Optional;

@Service
public class TrackedUserService {

    private final TrackedUserRepository repository;

    public TrackedUserService(TrackedUserRepository repository) {
        this.repository = repository;
    }

    public TrackedUser addUser(String username) {
        Optional<TrackedUser> existingUser = repository.findByUsername(username);
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("User already exists: " + username);
        }

        TrackedUser user = new TrackedUser(username);
        return repository.save(user);
    }
}
