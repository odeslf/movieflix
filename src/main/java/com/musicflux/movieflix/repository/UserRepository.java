package com.musicflux.movieflix.repository;

import com.musicflux.movieflix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
