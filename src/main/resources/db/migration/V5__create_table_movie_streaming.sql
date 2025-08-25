CREATE TABLE movie_streaming (
     movie_id BIGINT,
     streaming_id BIGINT,
     CONSTRAINT pk_movie_streaming PRIMARY KEY (movie_id, streaming_id),
     CONSTRAINT fk_movie_streaming_movie FOREIGN KEY (movie_id) REFERENCES movie(id),
     CONSTRAINT fk_movie_streaming_streaming FOREIGN KEY (streaming_id) REFERENCES streaming(id)
);