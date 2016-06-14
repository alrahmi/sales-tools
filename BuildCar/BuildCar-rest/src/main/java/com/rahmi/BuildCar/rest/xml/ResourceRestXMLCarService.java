package com.rahmi.BuildCar.rest.xml;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.Form;

import com.rahmi.BuildCar.controller.CarMapper;
import com.rahmi.BuildCar.model.Car;
import com.rahmi.BuildCar.util.filter.CarRequestForm;

@Path("/xml/cars")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class ResourceRestXMLCarService {
	

	@EJB
	private CarMapper carMapper;

	@GET
	@Path("/")
	public List<Car> getListAllCars(@Form CarRequestForm form) {
		return carMapper.getAll(form);
	}

	@GET
	@Path("/{id}")
	public Car getCarByID(@PathParam("id") Long id) {

		return carMapper.getById(id);
	}
}
