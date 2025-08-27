package com.musicflux.movieflix.service;

import com.musicflux.movieflix.model.Category;
import com.musicflux.movieflix.model.Streaming;
import com.musicflux.movieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {


    private final StreamingRepository repository;

    public List<Streaming> findAll() {
        return repository.findAll();
    }

    public Optional<Streaming> findById(Long id) {
        return repository.findById(id);
    }

    public Streaming saveStreaming(Streaming streaming) {
        return repository.save(streaming);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
