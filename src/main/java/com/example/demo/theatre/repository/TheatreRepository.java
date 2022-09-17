package com.example.demo.theatre.repository;

import com.example.demo.theatre.entity.TheatreEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TheatreRepository
        extends CrudRepository<TheatreEntity, Long> {
   public List<TheatreEntity> findByCity(String city);
}
