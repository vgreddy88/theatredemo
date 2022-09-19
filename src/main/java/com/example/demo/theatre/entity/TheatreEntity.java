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
@Table(name = "theatre")
public class TheatreEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int theatreid;
   private String theatrename;
   private String city;
   private String pincode;
   private String area;
}
