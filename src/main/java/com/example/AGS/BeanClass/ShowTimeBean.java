package com.example.AGS.BeanClass;

import java.sql.Time;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ShowTimeBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Ensures auto-generation of id
    private int id;

    private Time timee;  // The show time for the movie

    @JsonManagedReference  // This ensures the relationship is managed on the ShowTimeBean side
    @OneToMany(mappedBy = "timing")  // The mapping for the list of BookingSeatsBean
    private List<BookingSeatsBean> seat;

    @ManyToOne  // Many showtimes can belong to one movie
    @JoinColumn(name = "movieid")  // Foreign key column for movie
    @JsonBackReference  // Prevents infinite recursion (this is for the MovieBean side)
    private MovieBean movie;

    // Default constructor
    public ShowTimeBean() {}

    // Constructor for initialization
    public ShowTimeBean(int id, Time timee) {
        this.id = id;
        this.timee = timee;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getTimee() {
        return timee;
    }

    public void setTimee(Time timee) {
        this.timee = timee;
    }

    public List<BookingSeatsBean> getSeat() {
        return seat;
    }

    public void setSeat(List<BookingSeatsBean> seat) {
        this.seat = seat;
    }

    public MovieBean getMovie() {
        return movie;
    }

    public void setMovie(MovieBean movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "ShowTimeBean [id=" + id + ", timee=" + timee + ", seat=" + seat + "]";
    }
}
