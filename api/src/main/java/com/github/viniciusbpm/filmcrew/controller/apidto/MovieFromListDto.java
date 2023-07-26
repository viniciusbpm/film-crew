package com.github.viniciusbpm.filmcrew.controller.apidto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieFromListDto {
    private boolean adult;
    private String backdrop_path;
    private List<Integer> genre_ids;
    private Long id;
    private String original_language;
    private String original_title;
    private String overview;
    private BigDecimal popularity;
    private String poster_path;
    private LocalDate release_date;
    private String title;
    private boolean video;
    private BigDecimal vote_average;
    private int vote_count;
}
