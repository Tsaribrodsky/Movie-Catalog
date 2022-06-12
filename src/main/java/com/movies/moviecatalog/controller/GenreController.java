package com.movies.moviecatalog.controller;


import com.movies.moviecatalog.model.Genre;
import com.movies.moviecatalog.repository.GenreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/api/genres")
    public List<Genre> list(){
        return genreRepository.findAll();
    }

    @GetMapping("/api/genres/{genreId}")
    public Genre get(@PathVariable Long genreId){
        return genreRepository.getById(genreId);
    }

    @PostMapping("/api/genres")
    public Genre create(@RequestBody final Genre genre){
        return genreRepository.save(genre);
    }

    @DeleteMapping("/api/genres/{genreId}")
    public void delete(@PathVariable Long genreId){
        genreRepository.deleteById(genreId);
    }

    @PutMapping("/api/genres/{genreId}")
    public Genre update(@PathVariable Long genreId, @RequestBody Genre genre){
        Genre existingGenre = genreRepository.getById(genreId);
        BeanUtils.copyProperties(genre, existingGenre, "genreId");
        return genreRepository.save(existingGenre);
    }
}
