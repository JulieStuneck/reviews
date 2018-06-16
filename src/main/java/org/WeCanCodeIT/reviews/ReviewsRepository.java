package org.WeCanCodeIT.reviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewsRepository {

	private Map<Long, Review> listOfReviews = new HashMap<>();

	public ReviewsRepository() {

		Review road = new Review(1L, "Road Bike", "Painful, but potentially very fast.", "/images/Road.jpeg");
		Review tandom = new Review(2L, "Tandem", "Not great for getting anywhere, but makes for a fun afternoon.", "/images/Tandem.jpg");
		Review tricycle = new Review(3L, "Tricycle", "Won't go far or fast, but might be the best bike you'll ever have.", "/images/Tric.jpg");

		listOfReviews.put(road.getId(), road);
		listOfReviews.put(tandom.getId(), tandom);
		listOfReviews.put(tricycle.getId(), tricycle);
	}

	// below = the constructor used for developing tests (will use above for app)
	public ReviewsRepository(Review... anyAmountOfReviews) {
		for (Review anyReview : anyAmountOfReviews)
			listOfReviews.put(anyReview.getId(), anyReview);
	}

	public Review findOne(long id) {
		return listOfReviews.get(id);
	}

	public Collection<Review> findAll() {
		return listOfReviews.values();
	}

}
