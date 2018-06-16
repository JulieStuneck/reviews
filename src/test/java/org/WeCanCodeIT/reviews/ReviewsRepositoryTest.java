package org.WeCanCodeIT.reviews;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class ReviewsRepositoryTest {

	private long firstReviewId = 1L;
	private Review firstReview = new Review(firstReviewId, "bike name", "bike description", "image");

	private long secondReviewId = 2L;
	private Review secondReview = new Review(secondReviewId, "bike name", "bike description", "image");

	ReviewsRepository underTest;

	@Test
	public void shouldFindOneReview() {
		underTest = new ReviewsRepository(firstReview);
		Review result = underTest.findOne(firstReviewId);
		assertThat(result, is(firstReview));
	}

	@Test
	public void shouldFindASecondReview() {
		underTest = new ReviewsRepository(secondReview);
		Review result = underTest.findOne(secondReviewId);
		assertThat(result, is(secondReview));
	}

	@Test
	public void findAllReviews() {
		underTest = new ReviewsRepository(firstReview, secondReview);
		Collection<Review> foundReviews = underTest.findAll();
		assertThat(foundReviews, containsInAnyOrder(firstReview, secondReview));
	}

}
