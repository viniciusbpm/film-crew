package com.github.viniciusbpm.filmcrew.controller;

import com.github.viniciusbpm.filmcrew.controller.response.MovieResponse;
import com.github.viniciusbpm.filmcrew.service.ListPlayingMoviesService;
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

    @GetMapping("playing")
    public List<MovieResponse> playingMovies() {
        return listPlayingMoviesService.list();
    }
}
