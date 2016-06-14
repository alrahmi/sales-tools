package com.rahmi.BuildCar.rest.json;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.Form;

import com.rahmi.BuildCar.controller.CarMapper;
import com.rahmi.BuildCar.model.Car;
import com.rahmi.BuildCar.util.filter.CarRequestForm;

@Path("/json/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResourceRestCarService {

	@EJB
	private CarMapper carMapper;

	@GET
	@Path("/")
	public List<Car> getListAllCars(@Form CarRequestForm form) {
		return carMapper.getAll(form);
	}

	@POST
	@Path("/")
	public Car createCar(Car car) {
		carMapper.create(car);
		return car;
	}

	@PUT
	@Path("/{id}")
	public Car updateCar(@PathParam("id") Long id, Car car) {
		return carMapper.update(id,car);
		
	}

	@GET
	@Path("/{id}")
	public Car getCarByID(@PathParam("id") Long id) {

		return carMapper.getById(id);
	}

	@DELETE
	@Path("/{id}")
	public String deleteCar(@PathParam("id") Long id) {
		carMapper.remove(id);
		return "ok";
	}
}
