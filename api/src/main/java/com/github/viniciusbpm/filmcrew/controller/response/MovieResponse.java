package com.github.viniciusbpm.filmcrew.controller.response;

import lombok.*;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieResponse {
    private Long id;
    private String title;
    private String description;
    private boolean adult;
    private String backdropUrl;
    private String genre;
    private String posterUrl;
    private LocalDate releaseDate;
    private BigDecimal voteAverage;
}
