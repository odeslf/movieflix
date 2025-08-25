package com.musicflux.movieflix.repository;

import com.musicflux.movieflix.model.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}
