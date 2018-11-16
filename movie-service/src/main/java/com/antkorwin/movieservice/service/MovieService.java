package com.antkorwin.movieservice.service;

import com.antkorwin.movieservice.model.Movie;

import java.util.List;

/**
 * Created on 16.11.2018.
 *
 * @author Korovin Anatoliy
 */
public interface MovieService {
    List<Movie> getAll();
}
