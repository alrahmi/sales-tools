package com.rahmi.BuildCar.util.filter;

import org.codehaus.jackson.annotate.JsonProperty;

public class Sort {
	public static enum orderType {
		ASC, DESC
	}

	private String name;
	private orderType orderType;

	@JsonProperty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty
	public orderType getOrderType() {
		return orderType;
	}

	public void setOrderType(orderType orderType) {
		this.orderType = orderType;
	}

}
