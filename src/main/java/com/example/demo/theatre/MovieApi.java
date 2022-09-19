package com.example.demo.theatre;

import com.example.demo.theatre.model.ShowRequest;
import com.example.demo.theatre.model.ShowResponse;
import com.example.demo.theatre.model.TheatreResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public interface MovieApi {
   //passing apiKey or Validation ID
   //to make movie
   @GetMapping(value = "/getTheatres", produces = { "application/json" }, consumes = {
           "application/json" })
   public ResponseEntity<TheatreResponse> getTheatresListFromLocation(@RequestParam String city,
                                                                      @RequestParam String movieName,
                                                                      @RequestParam String date);

   @PostMapping(value = "/createShows", produces = { "application/json" }, consumes = {
           "application/json" })
   public ResponseEntity<ShowResponse> createShows(@RequestBody ShowRequest createShow);

   @PostMapping(value = "/updateShows", produces = { "application/json" }, consumes = {
           "application/json" })
   public ResponseEntity<ShowResponse> updateShows(@RequestBody ShowRequest createShow);

   @PostMapping(value = "/deleteShows", produces = { "application/json" }, consumes = {
           "application/json" })
   public ResponseEntity<ShowResponse> deleteShows(@RequestBody ShowRequest createShow);
}
