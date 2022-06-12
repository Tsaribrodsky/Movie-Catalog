package com.movies.moviecatalog.repository;

import com.movies.moviecatalog.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
