package org.WeCanCodeIT.reviews;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewsController {
	
	@Resource
	ReviewsRepository reviewsRepo;
	
	@RequestMapping("/show-reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("reviewsModel", reviewsRepo.findAll());
		return "reviewsTemplate";
	}
	
	@RequestMapping("/show-singe-review")
	public String findOneReview(@RequestParam(value="reviewId") Long reviewId, Model model) {

		return"reviewTemplate";
	}

}
