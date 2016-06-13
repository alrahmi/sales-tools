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
@NamedQueries({ @NamedQuery(name = "findEngineByType", query = "select e from Engine e where e.type= :type"),
		@NamedQuery(name = "findEngineByVolume", query = "select e from Engine e where e.volume= :volume"),
		@NamedQuery(name = "findEngineByPower", query = "select e from Engine e where e.power= :power") })
public class Engine implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String type;
	private double volume;
	private double power;
	private String serialNumber;
	@Id
	@GeneratedValue
	@JsonProperty
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
	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Column
	@JsonProperty
	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	@Column(unique = true)
	@JsonProperty
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}
