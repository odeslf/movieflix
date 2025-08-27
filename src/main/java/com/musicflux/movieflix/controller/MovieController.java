package com.musicflux.movieflix.controller;

import com.musicflux.movieflix.controller.request.MovieRequest;
import com.musicflux.movieflix.controller.response.MovieResponse;
import com.musicflux.movieflix.mapper.MovieMapper;
import com.musicflux.movieflix.model.Movie;
import com.musicflux.movieflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll() {
        List<MovieResponse> movies = movieService.findAll()
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList();

        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id) {
        return movieService.findById(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest request) {
        Movie savedMovie = movieService.save(MovieMapper.toMovie(request));
        return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id, @RequestBody MovieRequest request) {
        return movieService.update(id, MovieMapper.toMovie(request))
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findByCategory(Long category) {
        return ResponseEntity.ok(movieService.findByCategory(category)
                .stream().map(MovieMapper::toMovieResponse)
                .toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Movie> optionalMovie = movieService.findById(id);
        if(optionalMovie.isPresent()) {
            movieService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
