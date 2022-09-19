package com.example.demo.theatre;

import com.example.demo.theatre.model.ShowRequest;
import com.example.demo.theatre.model.ShowResponse;
import com.example.demo.theatre.model.TheatreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController implements MovieApi{

   @Autowired
   TheatreService theatreService;
   public ResponseEntity<TheatreResponse> getTheatresListFromLocation(String city, String movieName, String date)  {
      return new ResponseEntity<>(new TheatreResponse(
              theatreService.getTheatres(city, movieName, date)), HttpStatus.OK);
   }

   @Override
   public ResponseEntity<ShowResponse> createShows(ShowRequest createShow) {
      ShowResponse showResponse = theatreService.createShow(createShow);
      return new ResponseEntity<>(showResponse , HttpStatus.OK);
   }

   @Override
   public ResponseEntity<ShowResponse> updateShows(ShowRequest createShow) {
      ShowResponse showResponse = theatreService.updateShow(createShow);
      return new ResponseEntity<>(showResponse , HttpStatus.OK);
   }

   @Override
   public ResponseEntity<ShowResponse> deleteShows(ShowRequest createShow) {
      ShowResponse showResponse = theatreService.deleteShow(createShow);
      return new ResponseEntity<>(showResponse , HttpStatus.OK);
   }
}
