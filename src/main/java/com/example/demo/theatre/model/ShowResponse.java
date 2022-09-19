package com.example.demo.theatre.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShowResponse {
   private int theatreId;
   private int movieId;
   private String day;
   private String showsTiming;
   private List<Integer> screenIdList;
   private String Status;
}
