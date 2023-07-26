package com.github.viniciusbpm.filmcrew.mapper;

import com.github.viniciusbpm.filmcrew.controller.apidto.MovieFromListDto;
import com.github.viniciusbpm.filmcrew.controller.response.MovieResponse;

public class MovieMapper {
    public static MovieResponse toResponse(MovieFromListDto entity){
        return MovieResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .overview(entity.getOverview())
                .adult(entity.isAdult())
                .backdropPath(entity.getBackdrop_path())
                .popularity(entity.getPopularity())
                .poster(entity.getPoster_path())
                .releaseDate(entity.getRelease_date())
                .voteAverage(entity.getVote_average())
                .build();
    }
}
