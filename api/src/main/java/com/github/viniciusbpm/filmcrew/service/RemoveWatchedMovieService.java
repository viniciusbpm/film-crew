package com.github.viniciusbpm.filmcrew.service;

import com.github.viniciusbpm.filmcrew.controller.request.IdRequest;
import com.github.viniciusbpm.filmcrew.domain.Movie;
import com.github.viniciusbpm.filmcrew.domain.UserModel;
import com.github.viniciusbpm.filmcrew.mapper.UserMapper;
import com.github.viniciusbpm.filmcrew.repository.UserRepository;
import com.github.viniciusbpm.filmcrew.security.service.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class RemoveWatchedMovieService {
    public static final String MOVIE_NOT_ON_LIST = "This movie is not on the list";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @Transactional
    public void remove(IdRequest request){
        UserModel user = authenticatedUserService.get();

        Optional<Movie> watchedMovie = user.getWatchedMovies().stream()
                .filter(movie -> movie.getId().equals(request.getId()))
                .findFirst();

        if(watchedMovie.isEmpty()){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, MOVIE_NOT_ON_LIST);
        }
        
        user.removeWatchedMovie(watchedMovie.get());

        userRepository.save(user);
    }
}
