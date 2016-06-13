package com.rahmi.BuildCar.util.filter;

import javax.ws.rs.QueryParam;

public class CarBodyRequestForm extends RequestForm {
	private Integer countOfDoors;
	private String type;
	private String color;
	private String vin;

	public Integer getCountOfDoors() {
		return countOfDoors;
	}

	@QueryParam("countOfDoors")
	public void setCountOfDoors(Integer countOfDoors) {
		this.countOfDoors = countOfDoors;
	}

	public String getType() {
		return type;
	}
	@QueryParam("type")
	public void setType(String type) {
		this.type = type;
	}
	
	public String getColor() {
		return color;
	}
	@QueryParam("color")
	public void setColor(String color) {
		this.color = color;
	}

	public String getVin() {
		return vin;
	}
	@QueryParam("vin")
	public void setVin(String vin) {
		this.vin = vin;
	}

}
