package com.example.demo.theatre;

import com.example.demo.theatre.entity.MovieEntity;
import com.example.demo.theatre.entity.ScreenEntity;
import com.example.demo.theatre.entity.ShowsEntity;
import com.example.demo.theatre.entity.TheatreEntity;
import com.example.demo.theatre.model.ShowRequest;
import com.example.demo.theatre.model.Movie;
import com.example.demo.theatre.model.Screen;
import com.example.demo.theatre.model.ShowResponse;
import com.example.demo.theatre.model.Theatre;
import com.example.demo.theatre.repository.MovieRepository;
import com.example.demo.theatre.repository.ScreenRepository;
import com.example.demo.theatre.repository.ShowsRepository;
import com.example.demo.theatre.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

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
      List<Theatre> theatreList =  new ArrayList<>();

      theatreEntity.forEach(t -> {
         List<ShowsEntity> showsEntity = showsRepository.findByMovieIdAndTheatreId(
                 movieEntity.getMovieid(), date, t.getTheatreid());
         List<Screen> screenList = new ArrayList<>();
         showsEntity.forEach( s -> {
            ScreenEntity screenEntity = screenRepository.findByScreenId(s.getScreenid());
            Movie movie = new Movie(movieName, date, s.getShowtimings());
            Screen screen = new Screen(screenEntity.getScreennum(), screenEntity.getCapacity(), movie);
            screenList.add(screen);
         });
         if(!screenList.isEmpty()){
            Theatre theatre = new Theatre(t.getTheatrename(), city, t.getArea(), screenList);
            theatreList.add(theatre);
         }
      });
      return theatreList;
   }

   public ShowResponse createShow(ShowRequest createShow) {
      createShow.getScreenIdList().forEach( n -> {
         Random random = new Random();
         showsRepository.save(ShowsEntity.builder().showid(random.nextInt()).movieid(createShow.getMovieId())
         .screenid(n).showdate(createShow.getDay()).showtimings(createShow.getShowsTiming())
         .theatreid(createShow.getTheatreId()).build());
      });
      return new ShowResponse(createShow.getTheatreId(), createShow.getMovieId(),
              createShow.getDay(),  createShow.getShowsTiming(),
              createShow.getScreenIdList(), "CREATED");
   }

   public ShowResponse updateShow(ShowRequest createShow) {
      List<ShowsEntity> showsEntityList = showsRepository.findByMovieIdAndTheatreId(
              createShow.getMovieId(), createShow.getDay(), createShow.getTheatreId());
      AtomicInteger atomicInteger =  new AtomicInteger();
      createShow.getScreenIdList().forEach( n -> {
          ShowsEntity showsEntity = showsEntityList.get(atomicInteger.getAndIncrement());
          showsEntity.setScreenid(n);
          showsEntity.setShowtimings(createShow.getShowsTiming());
         showsRepository.save(showsEntity);
      });
      return new ShowResponse(createShow.getTheatreId(), createShow.getMovieId(),
              createShow.getDay(),  createShow.getShowsTiming(),
              createShow.getScreenIdList(), "UPDATED");
   }

   public ShowResponse deleteShow(ShowRequest createShow) {
      List<ShowsEntity> showsEntityList = showsRepository.findByMovieIdAndTheatreId(
              createShow.getMovieId(), createShow.getDay(), createShow.getTheatreId());
      createShow.getScreenIdList().forEach(s -> {
         ShowsEntity showsEntity = showsEntityList.stream().filter(show ->  show.getScreenid()==s).findFirst().get();
         showsRepository.delete(showsEntity);
      });
      return new ShowResponse(createShow.getTheatreId(), createShow.getMovieId(),
              createShow.getDay(),  createShow.getShowsTiming(),
              createShow.getScreenIdList(), "DELETED");
   }
}
