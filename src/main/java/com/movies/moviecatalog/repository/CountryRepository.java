package com.movies.moviecatalog.repository;

import com.movies.moviecatalog.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
