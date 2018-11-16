package com.antkorwin.ratingservice.api;

import com.antkorwin.ratingservice.feign.MovieServiceFeign;
import com.antkorwin.ratingservice.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

/**
 * Created on 16.11.2018.
 *
 * @author Korovin Anatoliy
 */
@RestController
@RequestMapping("ratings")
public class RatingController {

    private final MovieServiceFeign movieServiceFeign;
    private final RestTemplate restTemplate;

    @Autowired
    public RatingController(MovieServiceFeign movieServiceFeign,
                            RestTemplate restTemplate) {
        this.movieServiceFeign = movieServiceFeign;
        this.restTemplate = restTemplate;
    }

    @GetMapping("top")
    public Movie getTop(@RequestParam("genre") String genre) {
        List<Movie> movies = movieServiceFeign.getAll();
//                restTemplate.exchange("http://movie-service/movies/list",
//                                                   HttpMethod.GET,
//                                                   null,
//                                                   new ParameterizedTypeReference<List<Movie>>() {
//                                                   }).getBody();


        return movies.stream()
                     .filter(m -> m.getGenre().toUpperCase().contains(genre.toUpperCase()))
                     .findFirst()
                     .orElse(null);
    }

    @GetMapping("secret")
    @PreAuthorize("hasRole('ADMIN')")
    public Movie getSecret() {
        return new Movie(UUID.randomUUID(),
                         "top secret",
                         "action");
    }

    @GetMapping("info")
    public Object getInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) return null;

        return ((OAuth2Authentication) authentication).getUserAuthentication()
                                                      .getDetails();
    }
}
