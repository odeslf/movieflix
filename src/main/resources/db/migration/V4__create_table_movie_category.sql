CREATE TABLE movie_category (
    movie_id BIGINT,
    category_id BIGINT,
    CONSTRAINT pk_movie_category PRIMARY KEY (movie_id, category_id),
    CONSTRAINT fk_movie_category_movie FOREIGN KEY (movie_id) REFERENCES movie(id),
    CONSTRAINT fk_movie_category_category FOREIGN KEY (category_id) REFERENCES category(id)
);