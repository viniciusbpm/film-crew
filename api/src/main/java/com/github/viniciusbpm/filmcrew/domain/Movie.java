package com.github.viniciusbpm.filmcrew.domain;

import lombok.*;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class Movie {
    @Column(name="id", nullable = false)
    private Long id;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name="description", nullable = false)
    private String description;
    @Column(name="adult", nullable = false)
    private boolean adult;
    @Column(name="backdrop_url", nullable = false)
    private String backdropUrl;
    @Column(name="genre", nullable = false)
    private String genre;
    @Column(name="poster_url", nullable = false)
    private String posterUrl;
    @Column(name="release_date", nullable = false)
    private LocalDate releaseDate;
    @Column(name="vote_average", nullable = false)
    private BigDecimal voteAverage;
}
