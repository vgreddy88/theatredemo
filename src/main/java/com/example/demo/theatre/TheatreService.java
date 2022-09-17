package com.example.demo.theatre;

import com.example.demo.theatre.entity.MovieEntity;
import com.example.demo.theatre.entity.ScreenEntity;
import com.example.demo.theatre.entity.ShowsEntity;
import com.example.demo.theatre.entity.TheatreEntity;
import com.example.demo.theatre.model.Movie;
import com.example.demo.theatre.model.Screen;
import com.example.demo.theatre.model.Theatre;
import com.example.demo.theatre.repository.MovieRepository;
import com.example.demo.theatre.repository.ScreenRepository;
import com.example.demo.theatre.repository.ShowsRepository;
import com.example.demo.theatre.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TheatreService {

   @Autowired
   MovieRepository movieRepository;

   @Autowired
   ShowsRepository showsRepository;

   @Autowired
   TheatreRepository theatreRepository;

   @Autowired
   ScreenRepository screenRepository;


   public List<Theatre> getTheatres(String city, String movieName, String date) {

      MovieEntity movieEntity = movieRepository.findByName(movieName);
      List<TheatreEntity> theatreEntity = theatreRepository.findByCity(city);
      List<Long> theatreIds= theatreEntity.stream().map(TheatreEntity::getTheatreid).collect(Collectors.toList());
      List<ShowsEntity> showsEntity = showsRepository.findByMovieIdAndTheatreId(movieEntity.getMovieid(), date, theatreIds);
      List<Long> screenIds = showsEntity.stream().map(ShowsEntity::getScreenid).collect(Collectors.toList());
      List<ScreenEntity> screenList = screenRepository.findByScreenId(screenIds);
      List<Theatre> theatres = new ArrayList<>();
      showsEntity.stream().forEach(t -> {
         Movie movie = new Movie(movieName, date, t.getShowtimings());
         ScreenEntity screenEntity =
                 screenList.stream().filter(s -> s.getScreenid().equals(t.getScreenid())).findFirst().get();
         Screen screen = new Screen(screenEntity.getScreenum(), screenEntity.getCapacity(), movie);
         TheatreEntity theatreEntity1 =
                 theatreEntity.stream().filter(s -> s.getTheatreid().equals(t.getTheatreid())).findFirst().get();
        // Theatre theatre =  new Theatre(theatreEntity1.getTheatrename(), city, theatreEntity1.getArea(), screen);
      });

      return new ArrayList<>();
   }
}
