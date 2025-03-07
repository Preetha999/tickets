package com.example.AGS.BeanClass;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BookingSeatsBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private int seatNumber;
	private boolean isBooked;
	@ManyToOne

	@JoinColumn(name = "timingId")
	@JsonBackReference
	private ShowTimeBean timing;
	BookingSeatsBean(){
		
	}
	public BookingSeatsBean(int id, int seatNumber, boolean isBooked) {
		super();
		this.id = id;
		this.seatNumber = seatNumber;
		this.isBooked = isBooked;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public boolean isBooked() {
		return isBooked;
	}
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	
	public ShowTimeBean getTiming() {
		return timing;
	}
	public void setTiming(ShowTimeBean timing) {
		this.timing = timing;
	}
	
	

}
