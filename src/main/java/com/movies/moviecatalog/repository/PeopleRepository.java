package com.movies.moviecatalog.repository;

import com.movies.moviecatalog.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
