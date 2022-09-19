package com.example.demo.theatre.repository;

import com.example.demo.theatre.entity.ScreenEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ScreenRepository
        extends CrudRepository<ScreenEntity, Long> {
   @Query(nativeQuery = true,value = "select * from screen where screenid = ?1")
   public ScreenEntity findByScreenId(int screenId);
}
