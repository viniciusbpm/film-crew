package com.github.viniciusbpm.filmcrew.mapper;

import com.github.viniciusbpm.filmcrew.controller.apidto.MovieFromListDto;
import com.github.viniciusbpm.filmcrew.controller.response.MovieResponse;
import com.github.viniciusbpm.filmcrew.service.RequestToTmdbApiService;

import static com.github.viniciusbpm.filmcrew.service.RequestToTmdbApiService.BASE_API_URL;

public class MovieMapper {
    public static String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/original";
    public static MovieResponse toResponse(MovieFromListDto entity){
        return MovieResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .overview(entity.getOverview())
                .adult(entity.isAdult())
                .backdropPath(BASE_IMAGE_URL + entity.getBackdrop_path())
                .popularity(entity.getPopularity())
                .poster(BASE_IMAGE_URL + entity.getPoster_path())
                .releaseDate(entity.getRelease_date())
                .voteAverage(entity.getVote_average())
                .build();
    }
}
