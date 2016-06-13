package com.rahmi.BuildCar.util.filter;

import javax.ws.rs.QueryParam;

public class EngineRequestForm extends RequestForm {
	private String type;
	private Float volume;
	private Double power;
	private String serialNumber;

	public String getType() {
		return type;
	}
	@QueryParam("type")
	public void setType(String type) {
		this.type = type;
	}

	public float getVolume() {
		return volume;
	}
	@QueryParam("volume")
	public void setVolume(Float volume) {
		this.volume = volume;
	}

	public Double getPower() {
		return power;
	}
	@QueryParam("power")
	public void setPower(Double power) {
		this.power = power;
	}

	public String getSerialNumber() {
		return serialNumber;
	}
	@QueryParam("serialNumber")
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}
