package com.example.demo.theatre.repository;

import com.example.demo.theatre.entity.ShowsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShowsRepository
        extends CrudRepository<ShowsEntity, Long> {
   @Query(nativeQuery = true,value = "select * from shows where movieid = ?1 and showdate = ?2 and theatreid = ?3")
   public List<ShowsEntity> findByMovieIdAndTheatreId(int movieId, String date, int theatreId);
}
