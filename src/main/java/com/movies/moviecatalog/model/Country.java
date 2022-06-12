package com.movies.moviecatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "countries")
public class Country {
    @Id
    @SequenceGenerator(name = "country_sequence", sequenceName = "country_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "country_sequence")
    @Column(name = "country_id", updatable = false)
    private Long countryId;
    @Column(name = "country_name", nullable = false)
    private String countryName;
    @Column(name = "iso_code", nullable = false)
    @Size(min = 3, max = 3)
    private String isoCode;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<MovieCompany> movieCompany = new HashSet<>();

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<People> people = new HashSet<>();

    public Country(){
    }

    public Set<MovieCompany> getMovieCompany() {
        return movieCompany;
    }

    public void setMovieCompany(Set<MovieCompany> movieCompany) {
        this.movieCompany = movieCompany;
    }

    public Set<People> getPeople() {
        return people;
    }

    public void setPeople(Set<People> people) {
        this.people = people;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }
}
