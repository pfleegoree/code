package com.coderscampus.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarsPhoto {
	private Long id;
	private Integer sol;
	@JsonProperty("mars_camera")
	private MarsCamera marsCamera;
	@JsonProperty("img_src")
	private String imgSrc;
	@JsonProperty("earth_date")
	private String earthDate;

	private MarsRover rover;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getSol() {
		return sol;
	}
	public void setSol(Integer sol) {
		this.sol = sol;
	}
	public MarsCamera getMarsCamera() {
		return marsCamera;
	}
	public void setMarsCamera(MarsCamera marsCamera) {
		this.marsCamera = marsCamera;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	@Override
	public String toString() {
		return "MarsPhoto [id=" + id + ", sol=" + sol + ", marsCamera=" + marsCamera + ", imgSrc=" + imgSrc + "]";
	}
	public String getEarthDate() {
		return earthDate;
	}
	public void setEarthDate(String earthDate) {
		this.earthDate = earthDate;
	}
	public MarsRover getRover() {
		return rover;
	}
	public void setRover(MarsRover rover) {
		this.rover = rover;
	}
	
	
	
	

}
