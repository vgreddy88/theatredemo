package com.example.demo.theatre.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "shows")
public class ShowsEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long showId;
   private TheatreEntity theatreEntity;
   private ScreenEntity screenEntity;
   private MovieEntity movieEntity;
   private String showTimings;
   private String date;
}
