package ru.pubg.punx.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pubg.punx.jdo.TrackedUser;
import ru.pubg.punx.service.TrackedUserService;

@RestController
@RequestMapping("/api/users")
public class TrackedUserController {

    private final TrackedUserService service;

    public TrackedUserController(TrackedUserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody String username) {
        try {
            TrackedUser user = service.addUser(username);
            return ResponseEntity.ok("User added: " + user.getUsername());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}