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
@NamedQueries({
		@NamedQuery(name = "findTransmissionByType", query = "select t from Transmission t where t.type= :type"),
		@NamedQuery(name = "findTransmissionBySerialNumber", query = "select t from Engine t where t.serialNumber= :serialNumber") })
public class Transmission implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String type;
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

	@Column(unique = true)
	@JsonProperty
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}
