package com.github.viniciusbpm.filmcrew.mapper;

import com.github.viniciusbpm.filmcrew.controller.request.AddWatchedMovieRequest;
import com.github.viniciusbpm.filmcrew.controller.response.MovieResponse;
import com.github.viniciusbpm.filmcrew.domain.Movie;

public class MovieMapper {
    public static Movie toEntity(AddWatchedMovieRequest request){
        return Movie.builder()
                .id(request.getId())
                .title(request.getTitle())
                .releaseDate(request.getReleaseDate())
                .adult(request.isAdult())
                .voteAverage(request.getVoteAverage())
                .backdropUrl(request.getBackdropUrl())
                .genre(request.getGenre())
                .description(request.getDescription())
                .posterUrl(request.getPosterUrl())
                .build();
    }

    public static MovieResponse toResponse(Movie movie){
        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .releaseDate(movie.getReleaseDate())
                .adult(movie.isAdult())
                .voteAverage(movie.getVoteAverage())
                .backdropUrl(movie.getBackdropUrl())
                .genre(movie.getGenre())
                .description(movie.getDescription())
                .posterUrl(movie.getPosterUrl())
                .build();
    }
}
