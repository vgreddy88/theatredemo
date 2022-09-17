package com.example.demo.theatre;

import com.example.demo.theatre.model.TheatreResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface MovieApi {
   //passing apiKey or Validation ID
   //to make movie
   @GetMapping(value = "/getTheatres", produces = { "application/json" }, consumes = {
           "application/json" })
   public ResponseEntity<TheatreResponse> getTheatresListFromLocation(@RequestParam String city,
                                                                      @RequestParam String movieName,
                                                                      @RequestParam String date);
}
