package com.studentservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.studentservice.entity.Hotel;
import com.studentservice.entity.Review;
import com.studentservice.repository.HotelRepository;

@SpringBootTest
class StudentserviceApplicationTests {
	
	@Autowired
	private HotelRepository hotelRepository;

	@Test
	void addHotel() {
		Hotel h = new Hotel();
		h.setName("Hill view ooty");
		hotelRepository.save(h);
	}
	@Test
	void addReview() {
		Long hotelId = 1L;
		Hotel  hotel = hotelRepository.findById(hotelId).orElseThrow();
		Review review = new Review();
		review.setContent("Good");
		review.setRating(5);
		hotel.getReviews().add(review);
		hotelRepository.save(hotel);
	}
	@Test
	void deleteHotel() {
		hotelRepository.deleteById(1L);
	}

}
