package com.musicflux.movieflix.mapper;

import com.musicflux.movieflix.controller.request.StreamingRequest;
import com.musicflux.movieflix.controller.response.StreamingResponse;
import com.musicflux.movieflix.model.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest) {
        return Streaming
                .builder()
                .name(streamingRequest.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming) {
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
