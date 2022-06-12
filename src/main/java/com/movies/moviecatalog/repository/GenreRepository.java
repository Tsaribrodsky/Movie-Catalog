package com.movies.moviecatalog.repository;

import com.movies.moviecatalog.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
