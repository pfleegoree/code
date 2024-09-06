package com.coderscampus.response;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarsRover {
	private Long id;
    private String name;
    @JsonProperty("landing_date")
    private Date landingDate;
    @JsonProperty("launch_date")
    private Date launchDate;

    private String active;
    "max_sol": 4102,
    "max_date": "2024-02-19",
    "total_photos": 695670,
    "cameras": [

}
