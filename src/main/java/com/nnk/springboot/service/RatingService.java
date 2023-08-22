package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RatingService {
    Optional<Rating> findById(Integer id);
    Page<Rating> getPage(Pageable pageable);

    Rating save(Rating rating);

    Rating update(Rating rating);

    void delete(Integer ratingId);
}
