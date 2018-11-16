package com.antkorwin.movieservice.api;

import com.antkorwin.movieservice.model.Movie;
import com.antkorwin.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 16.11.2018.
 *
 * @author Korovin Anatoliy
 */
@RestController
@RequestMapping("movies")
public class MovieController {


    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("list")
    public List<Movie> getAll(){
        return movieService.getAll();
    }
}
