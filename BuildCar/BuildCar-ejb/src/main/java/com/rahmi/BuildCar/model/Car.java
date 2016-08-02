package com.rahmi.BuildCar.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import com.rahmi.BuildCar.util.deserializer.CarBodyDeserializer;
import com.rahmi.BuildCar.util.deserializer.EngineDeserializer;
import com.rahmi.BuildCar.util.deserializer.TransmissionDeserializer;



@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "findAllCars", query = "select c from Car c"),
		@NamedQuery(name = "findCarByEngine", query = "select c from Car c where c.engine= :engine"),
		@NamedQuery(name = "findCarByBody", query = "select c from Car c where c.body= :body") })
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private CarBody body;
	private Engine engine;
	private Transmission transmission;
	
	@Id
	@GeneratedValue
	@JsonProperty
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@JsonProperty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne
	@JsonProperty
	@JsonDeserialize(using=CarBodyDeserializer.class)
	public CarBody getBody() {
		return body;
	}

	public void setBody(CarBody body) {
		this.body = body;
	}

	@OneToOne
	@JsonProperty
	@JsonDeserialize(using=EngineDeserializer.class)
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@OneToOne
	@JsonProperty
	@JsonDeserialize(using=TransmissionDeserializer.class)
	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

}
