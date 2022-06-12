package com.movies.moviecatalog.repository;

import com.movies.moviecatalog.model.MovieCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCompanyRepository extends JpaRepository<MovieCompany, Long> {
}
