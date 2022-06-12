package com.movies.moviecatalog.controller;

import com.movies.moviecatalog.model.Movie;
import com.movies.moviecatalog.repository.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/api/movies")
    public List<Movie> list(){
        return movieRepository.findAll();
    }

    @GetMapping("/api/movies/{movieId}")
    public Movie get(@PathVariable Long movieId){
        return movieRepository.getById(movieId);
    }

    @PostMapping("/api/movies")
    public Movie create(@RequestBody final Movie movie){
        return movieRepository.save(movie);
    }

    @DeleteMapping("/api/movies/{movieId}")
    public void delete(@PathVariable Long movieId){
        movieRepository.deleteById(movieId);
    }

    @PutMapping("/api/movies/{movieId}")
    public Movie update(@PathVariable Long movieId, @RequestBody Movie movie){
        Movie existingMovie = movieRepository.getById(movieId);
        BeanUtils.copyProperties(movie, existingMovie, "movieId");
        return movieRepository.save(existingMovie);
    }

}
