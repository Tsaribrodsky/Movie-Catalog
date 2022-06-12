package com.movies.moviecatalog.controller;

import com.movies.moviecatalog.model.People;
import com.movies.moviecatalog.repository.PeopleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PeopleController {
    @Autowired
    private PeopleRepository peopleRepository;

    @GetMapping
    public List<People> list(){
        return peopleRepository.findAll();
    }

    @GetMapping("/{personId}")
    public People get(@PathVariable Long personId){
        return peopleRepository.getById(personId);
    }

    @PostMapping
    public People create(@RequestBody final People people){
        return peopleRepository.save(people);
    }

    @DeleteMapping("/{personId}")
    public void delete(@PathVariable Long personId){
        peopleRepository.deleteById(personId);
    }

    @PutMapping("/{personId}")
    public People update(@PathVariable Long personId, @RequestBody People people){
        People existingPeople = peopleRepository.getById(personId);
        BeanUtils.copyProperties(people, existingPeople, "personId");
        return peopleRepository.save(existingPeople);
    }
}
