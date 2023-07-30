package com.github.viniciusbpm.filmcrew.domain;

import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class UserModel {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name="username", nullable = false)
    private String username;
    @Column(name="email", nullable = false)
    private String email;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="profile_picture")
    private String profilePicture;
    @Column(name="active", nullable = false)
    private boolean active;
    @OneToMany
    @JoinColumn(name = "watched_movies")
    private List<MovieModel> watchedMovies;

    public void addWatchedMovie(MovieModel movie){
        this.watchedMovies.add(movie);
    }
}
