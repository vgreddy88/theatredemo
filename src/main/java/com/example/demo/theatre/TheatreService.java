package com.example.demo.theatre;

import com.example.demo.theatre.model.Movie;
import com.example.demo.theatre.model.Screen;
import com.example.demo.theatre.model.Theatre;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TheatreService {

   public List<Theatre> getTheatres(String city, String movieName, String date) {
//      Map<String, Integer> shows1 = new HashMap<>();
//      shows1.put("10:00", 120);
//      shows1.put("13:00", 120);
//      Map<String, Integer> shows2 = new HashMap<>();
//      shows2.put("10:00", 120);
//      shows2.put("13:00", 120);
//      Map<String, Integer> shows3 = new HashMap<>();
//      shows3.put("11:00", 120);
//      shows3.put("14:00", 120);
//      Movie movie1 = new Movie("movie1", "16-SEP-2022",shows1);
//      Movie movie2 = new Movie("movie2", "16-SEP-2022", shows2);
//      Movie movie3 = new Movie("movie1", "16-SEP-2022",shows3);
//      Screen screen1 =new Screen(1, 300, movie1);
//      Screen screen2 = new Screen(2, 300, movie2);
//      Screen screen3 = new Screen(1, 300, movie3);
//      List<Screen> listOfScreens1 = new ArrayList<>();
//      listOfScreens1.add(screen1);
//      listOfScreens1.add(screen2);
//      List<Screen> listOfScreens2 = new ArrayList<>();
//      listOfScreens2.add(screen3);
//      Theatre theatre1 = new Theatre("PVR", "100", "HYD", "KPHB", listOfScreens1);
//      Theatre theatre2 = new Theatre("AMB", "101", "HYD", "HITECHCITY", listOfScreens2);
//      List<Theatre> theatres = new ArrayList<>();
//      theatres.add(theatre1);
//      theatres.add(theatre2);

//      return  theatres.stream().filter(t -> t.getCity().equalsIgnoreCase(city))
//              .filter(t -> t.getScreens().stream().anyMatch(s -> s.getMovie().getName().equalsIgnoreCase(movieName)))
//              .collect(Collectors.toList());
      return null;
   }
}
