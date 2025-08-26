package com.musicflux.movieflix.service;

import com.musicflux.movieflix.model.Movie;
import com.musicflux.movieflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
    
    public Optional<Movie> findById(Long id){
        return movieRepository.findById(id);
    }
}
