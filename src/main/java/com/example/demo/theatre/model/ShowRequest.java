package com.example.demo.theatre.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShowRequest {
   private int theatreId;
   private int movieId;
   private String day;
   private String showsTiming;
   private List<Integer> screenIdList;
}
