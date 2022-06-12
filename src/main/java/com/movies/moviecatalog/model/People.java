package com.movies.moviecatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "people")
public class People {
    @Id
    @SequenceGenerator(name = "people_sequence", sequenceName = "people_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "people_sequence")
    @Column(name = "person_id", updatable = false)
    private Long personId;
    @Column(name = "person_name",nullable = false)
    private String personName;
    @Column(name = "person_surname", nullable = false)
    private String personSurname;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country country;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "people_role",
            joinColumns = { @JoinColumn(name = "person_id", nullable = false) },
            inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false) }
    )
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(mappedBy = "people", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Movie> movies = new HashSet<>();

    public People(){
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
