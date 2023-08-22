package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    @Override
    public Optional<Rating> findById(Integer id) {
        return this.ratingRepository.findById(id);
    }

    @Override
    public Page<Rating> getPage(Pageable pageable) {
        return this.ratingRepository.findAll(pageable);
    }

    @Override
    public Rating save(Rating rating) {
        return this.ratingRepository.save(rating);
    }

    @Override
    public Rating update(Rating rating) {
        return this.ratingRepository.save(rating);
    }

    @Override
    public void delete(Integer ratingId) {
        this.findById(ratingId).ifPresent(rating -> this.ratingRepository.deleteById(rating.getId()));
    }
}
