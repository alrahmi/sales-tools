package com.rahmi.BuildCar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({@NamedQuery(name="",query="select c from Car c"),
	@NamedQuery(name="",query="select c from Car c where c.engine= :engine"),
	@NamedQuery(name="",query="select c from Car c")})
public class Car  {
	@Id
	@GeneratedValue
	private long id;
	private CarBody body;
	private Engine engine;
	private Transmission transmission;

	@OneToOne
	public CarBody getBody() {
		return body;
	}

	public void setBody(CarBody body) {
		this.body = body;
	}

	@OneToOne
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@OneToOne
	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

}
