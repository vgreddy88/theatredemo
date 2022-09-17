package com.example.demo.theatre.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Movie {
   private String name;
   private String date;
   private Map<String, Integer> showAvailability;
}
