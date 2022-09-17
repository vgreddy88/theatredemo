package com.example.demo.theatre.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Screen {
   private int id;
   private int capacity;
   private Movie movie;
}
