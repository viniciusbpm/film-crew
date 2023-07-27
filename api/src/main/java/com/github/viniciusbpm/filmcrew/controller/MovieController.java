package com.github.viniciusbpm.filmcrew.controller;

import com.github.viniciusbpm.filmcrew.controller.response.MovieResponse;
import com.github.viniciusbpm.filmcrew.service.ListPlayingMoviesService;
import com.github.viniciusbpm.filmcrew.service.ListPopularMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    private ListPlayingMoviesService listPlayingMoviesService;

    @Autowired
    private ListPopularMoviesService listPopularMoviesService;


    @GetMapping("playing")
    public List<MovieResponse> playingMovies() {
        return listPlayingMoviesService.list();
    }

    @GetMapping("popular")
    public List<MovieResponse> popularMovies() {
        return listPopularMoviesService.list();
    }



}
