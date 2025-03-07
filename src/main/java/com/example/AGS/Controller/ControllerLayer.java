package com.example.AGS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AGS.BeanClass.BookingSeatsBean;
import com.example.AGS.BeanClass.MovieBean;
import com.example.AGS.BeanClass.ShowTimeBean;
import com.example.AGS.Service.Servicelayer;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ags")
public class ControllerLayer {

    @Autowired
    Servicelayer service;

    // Endpoint to add a new movie
    @PostMapping("/addmovie")
    public MovieBean addMovie(@Valid @RequestBody MovieBean movie) {
        return service.addMovie(movie);
    }

    // Endpoint to add a new showtime
    @PostMapping("/addshowtime")
    public ShowTimeBean addShowTime(@RequestBody ShowTimeBean showTime) {
        return service.addShowTime(showTime);
    }

    // Endpoint to add a new seat
    @PostMapping("/addseat")
    public BookingSeatsBean addSeat(@Valid @RequestBody BookingSeatsBean seat) {
        return service.addSeat(seat);
    }

    // Endpoint to book a seat
    @PostMapping("/bookseat/{seatNumber}")
    public String bookSeat(@PathVariable int seatNumber) {
        return service.bookSeat(seatNumber);
    }

    // Optional endpoints for fetching data

    // Get all movies
    @GetMapping("/movies")
    public List<MovieBean> getAllMovies() {
        return service.getMovieList();
    }

    // Get all showtimes
    @GetMapping("/showtimes")
    public List<ShowTimeBean> getAllShowTimes() {
        return service.getAllShowTimes();
    }

    // Get seats for a specific showtime
    @GetMapping("/seats/{showTimeId}")
    public List<BookingSeatsBean> getSeatsForShowTime(@PathVariable int showTimeId) {
        return service.getSeatsForShowTime(showTimeId);
    }
}
