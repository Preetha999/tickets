package com.example.AGS.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AGS.BeanClass.BookingSeatsBean;
import com.example.AGS.BeanClass.MovieBean;
import com.example.AGS.BeanClass.ShowTimeBean;
import com.example.AGS.Repository.BookSeat;
import com.example.AGS.Repository.Movie;
import com.example.AGS.Repository.ShowTime;

@Service
public class Servicelayer {

    @Autowired
    private Movie movieRepository;

    @Autowired
    private ShowTime showTimeRepository;

    @Autowired
    private BookSeat seatRepository;

    // Add a new movie
    public MovieBean addMovie(MovieBean movie) {
        return movieRepository.save(movie);
    }

    // Add a new showtime
    public ShowTimeBean addShowTime(ShowTimeBean showTime) {
        return showTimeRepository.save(showTime);
    }

    // Add a new seat
    public BookingSeatsBean addSeat(BookingSeatsBean seat) {
        return seatRepository.save(seat);
    }

    // Book a seat
    public String bookSeat(int seatNumber) {
        Optional<BookingSeatsBean> optionalSeat = seatRepository.findBySeatNumber(seatNumber);
        if (optionalSeat.isPresent()) {
            BookingSeatsBean seat = optionalSeat.get();
            if (!seat.isBooked()) {
                seat.setBooked(true);
                seatRepository.save(seat);
                return "Seat " + seatNumber + " successfully booked.";
            } else {
                return "Seat " + seatNumber + " is already booked.";
            }
        } else {
            return "Seat " + seatNumber + " does not exist.";
        }
    }

    // Get all movies
    public List<MovieBean> getMovieList() {
        return movieRepository.findAll();
    }

    // Get all showtimes
    public List<ShowTimeBean> getAllShowTimes() {
        return showTimeRepository.findAll();
    }

    // Get seats for a specific showtime
    public List<BookingSeatsBean> getSeatsForShowTime(int showTimeId) {
        Optional<ShowTimeBean> optionalShowTime = showTimeRepository.findById(showTimeId);
        if (optionalShowTime.isPresent()) {
            return optionalShowTime.get().getSeat();
        } else {
            throw new RuntimeException("Showtime with ID " + showTimeId + " not found.");
        }
    }
}
