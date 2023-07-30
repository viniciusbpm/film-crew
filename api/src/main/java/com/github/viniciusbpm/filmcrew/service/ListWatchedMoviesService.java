package com.github.viniciusbpm.filmcrew.service;

import com.github.viniciusbpm.filmcrew.controller.response.MovieResponse;
import com.github.viniciusbpm.filmcrew.domain.UserModel;
import com.github.viniciusbpm.filmcrew.mapper.MovieMapper;
import com.github.viniciusbpm.filmcrew.security.service.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ListWatchedMoviesService {
    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    public List<MovieResponse> list(){
        UserModel user = authenticatedUserService.get();

        return user.getWatchedMovies().stream()
                .map(MovieMapper::toResponse)
                .collect(toList());
    }
}
