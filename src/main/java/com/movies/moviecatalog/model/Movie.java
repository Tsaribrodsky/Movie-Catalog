package com.movies.moviecatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "movies")
public class Movie {
    @Id
    @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "movie_sequence")
    @Column(name = "movie_id", updatable = false)
    private Long movieId;
    @Column(name = "movie_name", nullable = false)
    private String movieName;
    @Column(name = "movie_year", nullable = false)
    private int movieYear;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id",referencedColumnName = "company_id")
    private MovieCompany movieCompany;
    @Column(name = "movie_description", nullable = false)
    private String movieDescription;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_genre",
            joinColumns = { @JoinColumn(name = "movie_id", nullable = false) },
            inverseJoinColumns = { @JoinColumn(name = "genre_id", nullable = false) }
    )
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_people",
            joinColumns = { @JoinColumn(name = "movie_id", nullable = false) },
            inverseJoinColumns = { @JoinColumn(name = "person_id", nullable = false) }
    )
    private Set<People> people = new HashSet<>();

    public Movie(){
    }

    public Set<People> getPeople() {
        return people;
    }

    public void setPeople(Set<People> people) {
        this.people = people;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public MovieCompany getMovieCompany() {
        return movieCompany;
    }

    public void setMovieCompany(MovieCompany movieCompany) {
        this.movieCompany = movieCompany;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }
}
