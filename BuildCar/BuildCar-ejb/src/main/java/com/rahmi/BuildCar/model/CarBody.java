package com.rahmi.BuildCar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@XmlRootElement
public class CarBody  {
	@Id
	@GeneratedValue
	private long id;
	private String type;
	private String color;
	private int numberOfDoors;
	private String VIN;

	@Column
	@JsonProperty
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	@Column
	@JsonProperty
	public void setColor(String color) {
		this.color = color;
	}

	@Column
	@JsonProperty
	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	@Column
	@JsonProperty
	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vIN) {
		VIN = vIN;
	}
}
