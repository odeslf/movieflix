CREATE TABLE movie (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    release_date DATE,
    rating DOUBLE,
    created_at DATETIME,
    updated_at DATETIME
);
