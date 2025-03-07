package com.example.AGS.Repository;

import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AGS.BeanClass.ShowTimeBean;
@Repository
public interface ShowTime extends JpaRepository<ShowTimeBean, Integer>{

	List<ShowTimeBean> findByTimee(Time timee);

}
