package com.example.AGS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AGS.BeanClass.MovieBean;
@Repository
public interface Movie extends JpaRepository<MovieBean, Integer> {
	public MovieBean findByMovieName(String moviename);

}