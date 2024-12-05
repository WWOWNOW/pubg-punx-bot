package ru.pubg.punx.jdo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "tracked_users")
@RequiredArgsConstructor
@AllArgsConstructor
public class TrackedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    public TrackedUser(String username) {
        this.username = username;
    }

}
