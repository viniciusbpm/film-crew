package com.github.viniciusbpm.filmcrew.service;

import com.github.viniciusbpm.filmcrew.domain.Movie;
import com.github.viniciusbpm.filmcrew.domain.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class ValidateUniqueWatchedMovieService {
    public static final String FILME_JA_ADICIONADO = "Este filme já está na lista de assistidos";
    public void validate(UserModel userModel, Movie movie){
        Optional<Movie> duplicatedMovie = userModel.getWatchedMovies().stream()
                .filter(watchedMovie -> watchedMovie.getId().equals(movie.getId()))
                .findFirst();

        if(duplicatedMovie.isPresent()){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, FILME_JA_ADICIONADO);
        }
    }
}
