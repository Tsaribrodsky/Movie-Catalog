package com.movies.moviecatalog.repository;

import com.movies.moviecatalog.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
