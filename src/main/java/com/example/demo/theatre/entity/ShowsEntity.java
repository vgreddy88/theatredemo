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
   private Long showid;
   private Long theatreid;
   private Long screenid;
   private Long movieid;
   private String showtimings;
   private String showdate;
}
