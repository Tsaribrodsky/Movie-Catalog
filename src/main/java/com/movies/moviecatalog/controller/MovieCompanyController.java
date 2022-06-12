package com.movies.moviecatalog.controller;

import com.movies.moviecatalog.model.MovieCompany;
import com.movies.moviecatalog.repository.MovieCompanyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class MovieCompanyController {
    @Autowired
    private MovieCompanyRepository movieCompanyRepository;

    @GetMapping
    public List<MovieCompany> list(){
        return movieCompanyRepository.findAll();
    }

    @GetMapping("/{companyId}")
    public MovieCompany get(@PathVariable Long companyId){
        return movieCompanyRepository.getById(companyId);
    }

    @PostMapping
    public MovieCompany create(@RequestBody final MovieCompany movieCompany){
        return movieCompanyRepository.save(movieCompany);
    }

    @DeleteMapping("/{companyId}")
    public void delete(@PathVariable Long companyId){
        movieCompanyRepository.deleteById(companyId);
    }

    @PutMapping("/{companyId}")
    public MovieCompany update(@PathVariable Long companyId, @RequestBody MovieCompany movieCompany){
        MovieCompany existingMovieCompany = movieCompanyRepository.getById(companyId);
        BeanUtils.copyProperties(movieCompany, existingMovieCompany, "companyId");
        return movieCompanyRepository.save(existingMovieCompany);
    }
}
