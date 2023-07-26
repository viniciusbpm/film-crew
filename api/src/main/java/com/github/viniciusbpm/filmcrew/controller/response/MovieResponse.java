package com.github.viniciusbpm.filmcrew.controller.response;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class MovieResponse {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;
    private String overview;
    private boolean adult;
    private String backdropPath;
    private String poster;
    private BigDecimal popularity;
    private BigDecimal voteAverage;
    private LocalDate releaseDate;
}
