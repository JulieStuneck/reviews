package org.WeCanCodeIT.reviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewsRepository {

	private Map<Long, Review> listOfReviews = new HashMap<>();

	public ReviewsRepository() {

		Review road = new Review(1L, "road bike", "painful, but fast");
		Review tandom = new Review(2L, "tandom", "great for a get-away");
		Review tricycle = new Review(3L, "tricycle", "won't go far, but might be the best bike you'll ever have");

		listOfReviews.put(road.getId(), road);
		listOfReviews.put(tandom.getId(), tandom);
		listOfReviews.put(tricycle.getId(), tricycle);
	}

	// below = the constructor used for developing tests (will use above for app)
	public ReviewsRepository(Review... anyAmountOfReviews) {
		for (Review anyReview : anyAmountOfReviews)
			listOfReviews.put(anyReview.getId(), anyReview);
	}

	public Review findOne(long reviewId) {
		return listOfReviews.get(reviewId);
	}

	public Collection<Review> findAll() {
		return listOfReviews.values();
	}

}
