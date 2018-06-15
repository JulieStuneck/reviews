package org.WeCanCodeIT.reviews;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewsController.class)

public class ReviewsControllerMockMvcTest {

	@Resource
	private MockMvc mvc;

	@Mock
	private Review firstReview;

	@Mock
	private Review secondReview;

	@MockBean
	private ReviewsRepository reviewsRepo;

	@Test
	public void statusShouldBeOkForAllReviews() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(status().isOk());
	}

	@Test
	public void shouldGenerateViewForAllReviews() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(view().name(is("reviewsTemplate")));
	}

	@Test
	public void shouldPutAllReviewsIntoModel() throws Exception {
		Collection<Review> allReviewsInModel = Arrays.asList(firstReview, secondReview);
		when(reviewsRepo.findAll()).thenReturn(allReviewsInModel);
		mvc.perform(get("/show-reviews")).andExpect(model().attribute("reviewsModel", is(allReviewsInModel)));
	}
	
	@Test
	public void shouldBeOkForOneReview() throws Exception {
		mvc.perform(get("/show-single-review?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToASingleReviewView() throws Exception {
		mvc.perform(get("/show-single-review?id=1")).andExpect(view().name(is("reviewTemplate")));
	}
	
	@Test
	public void shouldPutASingleReviewIntoModel() throws Exception {
		when(reviewsRepo.findOne(1L)).thenReturn(firstReview);
		
		mvc.perform(get("/show-single-review?id=1")).andExpect(model().attribute("reviewsModel", is(firstReview)));
	}

}
