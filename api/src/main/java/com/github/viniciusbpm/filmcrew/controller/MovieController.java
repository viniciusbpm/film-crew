package com.github.viniciusbpm.filmcrew.controller;

import com.github.viniciusbpm.filmcrew.controller.request.AddWatchedMovieRequest;
import com.github.viniciusbpm.filmcrew.controller.request.IdRequest;
import com.github.viniciusbpm.filmcrew.controller.response.MovieResponse;
import com.github.viniciusbpm.filmcrew.service.AddWatchedMovieService;
import com.github.viniciusbpm.filmcrew.service.ListWatchedMoviesService;
import com.github.viniciusbpm.filmcrew.service.RemoveWatchedMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private ListWatchedMoviesService listWatchedMoviesService;
    @Autowired
    private AddWatchedMovieService addWatchedMovieService;
    @Autowired
    private RemoveWatchedMovieService removeWatchedMovieService;

    @GetMapping("watched")
    public List<MovieResponse> listWatchedMovies(){
        return listWatchedMoviesService.list();
    }
    @PostMapping("watched")
    public void addWatchedMovie(@RequestBody AddWatchedMovieRequest request){
        addWatchedMovieService.add(request);
    }

    @DeleteMapping("watched")
    public void removeWatchedMovie(@RequestBody IdRequest request){
        removeWatchedMovieService.remove(request);
    }


}
