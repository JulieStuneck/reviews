package org.WeCanCodeIT.reviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewsRepository {

	private Map<Long, Review> listOfReviews = new HashMap<>();

	public ReviewsRepository(Review... anyAmountOfReviews) {
		for (Review anyReview : anyAmountOfReviews)
			listOfReviews.put(anyReview.getReviewId(), anyReview);
	}

	public Review findOne(long reviewId) {
		return listOfReviews.get(reviewId);
	}

	public Collection<Review> findAll() {
		return listOfReviews.values();
	}

}
