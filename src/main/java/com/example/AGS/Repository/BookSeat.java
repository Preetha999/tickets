package com.example.AGS.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AGS.BeanClass.BookingSeatsBean;
@Repository
public interface BookSeat extends JpaRepository<BookingSeatsBean, Integer>{

	Optional<BookingSeatsBean> findBySeatNumber(int seatNumber);

	

}
