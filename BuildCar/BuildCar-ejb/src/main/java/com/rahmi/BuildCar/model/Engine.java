package com.rahmi.BuildCar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@XmlRootElement
@NamedQueries({ 
	    @NamedQuery(name = "", query = "select c from Engine c"),
		@NamedQuery(name = "", query = "select c from Engine c where c.power= :power"),
		@NamedQuery(name = "", query = "select c from Engine c") })
public class Engine {
	@Id
	@GeneratedValue
	private long id;
	private String type;
	private float volume;
	private double power;
	private String serialNumber;

	@Column
	@XmlElement
	@JsonProperty
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column
	@XmlElement
	@JsonProperty
	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	@Column
	@XmlElement
	@JsonProperty
	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	@Column(unique = true)
	@XmlElement
	@JsonProperty
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}
