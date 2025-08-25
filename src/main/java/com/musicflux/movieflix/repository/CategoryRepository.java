package com.musicflux.movieflix.repository;

import com.musicflux.movieflix.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
