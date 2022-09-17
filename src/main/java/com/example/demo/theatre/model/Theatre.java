package com.example.demo.theatre.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Theatre {
   private String name;
   private String id;
   private String city;
   private String area;
   private List<Screen> screens;
}
