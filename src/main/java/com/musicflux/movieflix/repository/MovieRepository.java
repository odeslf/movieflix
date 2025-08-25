package com.musicflux.movieflix.repository;

import com.musicflux.movieflix.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
