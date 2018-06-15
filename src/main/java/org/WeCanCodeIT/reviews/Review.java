package org.WeCanCodeIT.reviews;

public class Review {

	private long id;
	private String bikeType;
	private String description;

	public Long getId() {
		return id;
	}

	public String getBikeType() {
		return bikeType;
	}

	public String getDescription() {
		return description;
	}

	public Review(long reviewId, String bikeType, String description) {
		this.id = reviewId;
		this.bikeType = bikeType;
		this.description = description;

	}

}
