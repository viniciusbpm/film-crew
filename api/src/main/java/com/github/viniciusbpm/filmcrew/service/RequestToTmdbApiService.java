package com.github.viniciusbpm.filmcrew.service;

import com.github.viniciusbpm.filmcrew.controller.apidto.MovieListResultDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;
import static java.lang.System.getenv;

@Service
public class RequestToTmdbApiService {
    public static String BASE_API_URL = "https://api.themoviedb.org/3";
    public static String API_KEY_QUERY_PARAM = "?api_key=" + getenv("API_KEY");
    public MovieListResultDto listPlayingMovies(){
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<MovieListResultDto> resp = restTemplate.getForEntity(format("%s/movie/now_playing%s", BASE_API_URL, API_KEY_QUERY_PARAM)
                , MovieListResultDto.class);

        return resp.getBody();
    }

    public MovieListResultDto listPopularMovies(){
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<MovieListResultDto> resp = restTemplate.getForEntity(format("%s/movie/popular%s",
                BASE_API_URL, API_KEY_QUERY_PARAM), MovieListResultDto.class);

        return resp.getBody();
    }


}
