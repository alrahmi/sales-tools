package com.rahmi.BuildCar.util.filter;

import javax.ws.rs.QueryParam;

public class TransmissionRequestForm extends RequestForm {
	private String type;
	private String serialNumber;

	public String getType() {
		return type;
	}

	@QueryParam("type")
	public void setType(String type) {
		this.type = type;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	@QueryParam("serialNumber")
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}
