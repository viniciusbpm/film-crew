package com.github.viniciusbpm.filmcrew.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class AddWatchedMovieRequest {
    @NotNull
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private boolean adult;
    @NotBlank
    private String backdropUrl;
    @NotBlank
    private String genre;
    @NotBlank
    private String posterUrl;
    @NotNull
    private LocalDate releaseDate;
    @NotNull
    private BigDecimal voteAverage;
}
