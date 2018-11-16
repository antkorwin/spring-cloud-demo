package com.antkorwin.ratingservice.feign;

import com.antkorwin.ratingservice.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created on 16.11.2018.
 *
 * @author Korovin Anatoliy
 */
@FeignClient(value = "movie-service",
             path = "movies")
public interface MovieServiceFeign {

    @GetMapping("list")
    List<Movie> getAll();
}
