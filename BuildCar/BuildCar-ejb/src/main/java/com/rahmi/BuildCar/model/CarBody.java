package com.rahmi.BuildCar.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonProperty;



@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({ @NamedQuery(name = "findBodyByType", query = "select c from CarBody c where c.type= :type"),
		@NamedQuery(name = "findBodyByColor", query = "select c from CarBody c where c.color= :color"),
		@NamedQuery(name = "findBodyCountOfDoors", query = "select c from CarBody c where c.countOfDoors= :numberOfDoors") })

public class CarBody implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String type;
	private String color;
	private int countOfDoors;
	private String VIN;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
	@JsonProperty
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column
	@JsonProperty
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column
	@JsonProperty
	public int getCountOfDoors() {
		return countOfDoors;
	}

	public void setCountOfDoors(int numberOfDoors) {
		this.countOfDoors = numberOfDoors;
	}

	@Column(unique = true)
	@JsonProperty
	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vIN) {
		VIN = vIN;
	}
}
