package com.musicflux.movieflix.controller;

import com.musicflux.movieflix.controller.request.CategoryRequest;
import com.musicflux.movieflix.controller.request.StreamingRequest;
import com.musicflux.movieflix.controller.response.StreamingResponse;
import com.musicflux.movieflix.mapper.StreamingMapper;
import com.musicflux.movieflix.model.Category;
import com.musicflux.movieflix.model.Streaming;
import com.musicflux.movieflix.service.CategoryService;
import com.musicflux.movieflix.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
public class StreamingController {

    @Autowired
    private StreamingService service;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> findAll() {
        List<StreamingResponse> streamings  = service.findAll()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();

        return ResponseEntity.ok(streamings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findById(@PathVariable Long id){
        return service.findById(id)
                .map(streaming ->ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> saveStreaming(@RequestBody StreamingRequest request) {
        Streaming savedStreaming = service.saveStreaming(StreamingMapper.toStreaming(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
