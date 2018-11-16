package com.antkorwin.movieservice.repository;

import com.antkorwin.movieservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created on 16.11.2018.
 *
 * @author Korovin Anatoliy
 */
public interface MovieRepository extends JpaRepository<Movie,UUID>{
}
