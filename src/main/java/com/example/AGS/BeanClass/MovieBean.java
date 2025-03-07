package com.example.AGS.BeanClass;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class MovieBean {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     private int price;
     private String movieName,actor,actress,genre;
     @JsonManagedReference
     @OneToMany(mappedBy="movie")
     private List<ShowTimeBean> time;
     MovieBean(){
    	 
     }
     public MovieBean(int id,int price,String movieName,String actor,String actress,String genre){
    	 this.id=id;
    	 this.price=price;
    	 this.movieName=movieName;
    	 this.actor=actor;
    	 this.actress=actress;
    	 this.genre=genre; 
     }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActress() {
		return actress;
	}
	public void setActress(String actress) {
		this.actress = actress;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public List<ShowTimeBean> getTime() {
		return time;
	}
	public void setTime(List<ShowTimeBean> time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "MovieBean [id=" + id + ", price=" + price + ", movieName=" + movieName + ", actor=" + actor
				+ ", actress=" + actress + ", genre=" + genre + "]";
	}
     
}
