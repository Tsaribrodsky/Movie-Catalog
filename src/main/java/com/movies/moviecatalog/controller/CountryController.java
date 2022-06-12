package com.movies.moviecatalog.controller;

import com.movies.moviecatalog.model.Country;
import com.movies.moviecatalog.repository.CountryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public List<Country> list(){
        return countryRepository.findAll();
    }

    @GetMapping("/{countryId}")
    public Country get(@PathVariable Long countryId){
        return countryRepository.getById(countryId);
    }

    @PostMapping
    public Country create(@RequestBody final Country country){
        return countryRepository.save(country);
    }

    @DeleteMapping("/{countryId}")
    public void delete(@PathVariable Long countryId){
        countryRepository.deleteById(countryId);
    }

    @PutMapping("/{countryId}")
    public Country update(@PathVariable Long countryId, @RequestBody Country country){
        Country existingCountry = countryRepository.getById(countryId);
        BeanUtils.copyProperties(country, existingCountry, "countryId");
        return countryRepository.save(existingCountry);
    }
}
