package com.github.viniciusbpm.filmcrew.service;

import com.github.viniciusbpm.filmcrew.controller.request.AddWatchedMovieRequest;
import com.github.viniciusbpm.filmcrew.domain.Movie;
import com.github.viniciusbpm.filmcrew.domain.UserModel;
import com.github.viniciusbpm.filmcrew.repository.UserRepository;
import com.github.viniciusbpm.filmcrew.security.service.GetAuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.github.viniciusbpm.filmcrew.mapper.MovieMapper.toEntity;

@Service
public class AddWatchedMovieService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GetAuthenticatedUserService getAuthenticatedUserService;
    @Autowired
    private ValidateUniqueWatchedMovieService validateUniqueWatchedMovieService;

    @Transactional
    public void add(AddWatchedMovieRequest request){
        UserModel user = getAuthenticatedUserService.get();

        Movie movie = toEntity(request);

        validateUniqueWatchedMovieService.validate(user, movie);

        user.addWatchedMovie(movie);

        userRepository.save(user);
    }
}
