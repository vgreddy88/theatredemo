package com.example.demo.theatre.repository;

import com.example.demo.theatre.entity.ShowsEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShowsRepository
        extends CrudRepository<ShowsEntity, Long> {
}
