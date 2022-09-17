package com.example.demo.theatre.repository;

import com.example.demo.theatre.entity.TheatreEntity;
import org.springframework.data.repository.CrudRepository;

public interface TheatreRepository
        extends CrudRepository<TheatreEntity, Long> {
}
