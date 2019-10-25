package com.rating.youtube_rating.repository;

import java.util.List;
import java.util.Optional;

import com.rating.youtube_rating.model.Rating;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating,Long>{
    List<Rating> findAll();

    Optional<Rating> findById(Long id);

}