package com.rahmi.BuildCar.util.filter;

import javax.ws.rs.QueryParam;

public class CarRequestForm extends RequestForm {
	private String name;

	public String getName() {
		return name;
	}

	@QueryParam("name")
	public void setName(String name) {
		this.name = name;
	}

}
