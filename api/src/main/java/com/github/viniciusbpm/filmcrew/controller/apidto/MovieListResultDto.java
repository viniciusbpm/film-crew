package com.github.viniciusbpm.filmcrew.controller.apidto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieListResultDto {
    private DatesDto dates;
    private int page;
    private List<MovieFromListDto> results;
    private int totalPages;
    private int totalResults;
}
