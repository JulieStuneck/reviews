package org.WeCanCodeIT.reviews;

public class Review {

	private long id;
	private String bikeType;
	private String description;
	private String image;

	public Long getId() {
		return id;
	}

	public String getBikeType() {
		return bikeType;
	}

	public String getDescription() {
		return description;
	}
	
	public String getImage() {
		return image;
	}

	public Review(long id, String bikeType, String description, String image) {
		this.id = id;
		this.bikeType = bikeType;
		this.description = description;
		this.image = image;

	}

}
