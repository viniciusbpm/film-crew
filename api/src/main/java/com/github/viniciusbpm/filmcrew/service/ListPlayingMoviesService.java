package com.github.viniciusbpm.filmcrew.service;

import com.github.viniciusbpm.filmcrew.controller.apidto.MovieListResultDto;
import com.github.viniciusbpm.filmcrew.controller.response.MovieResponse;
import com.github.viniciusbpm.filmcrew.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListPlayingMoviesService {
    @Autowired
    private RequestToTmdbApiService requestToTmdbApiService;

    public List<MovieResponse> list(){
        MovieListResultDto response = requestToTmdbApiService.listPlayingMovies();

        return response.getResults().stream()
                .map(MovieMapper::toResponse)
                .collect(Collectors.toList());
    }
}
