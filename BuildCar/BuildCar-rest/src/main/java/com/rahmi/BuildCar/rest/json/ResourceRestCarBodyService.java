package com.rahmi.BuildCar.rest.json;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.Form;

import com.rahmi.BuildCar.controller.BodyMapper;
import com.rahmi.BuildCar.controller.TransMapper;
import com.rahmi.BuildCar.model.CarBody;
import com.rahmi.BuildCar.model.Transmission;
import com.rahmi.BuildCar.util.filter.CarBodyRequestForm;
import com.rahmi.BuildCar.util.filter.RequestForm;

@Path("/rest/json/carBody")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResourceRestCarBodyService {
	
	@EJB
	private BodyMapper bodyMapper;

	@GET
	@Path("/")
	public List<CarBody> getListAllCarBody(@Form CarBodyRequestForm form) {
		return bodyMapper.getAll(form);
	}

	@POST
	@Path("/")
	public CarBody createCarBody(CarBody carBody) {
		bodyMapper.create(carBody);
		return carBody;
	}

	@PUT
	@Path("/{id}")
	public CarBody updateCarBody(@PathParam("id") Long id, CarBody carBody) {
		bodyMapper.refresh(carBody);
		return carBody;
	}

	@GET
	@Path("/{id}")
	public CarBody getCarBodyByID(@PathParam("id") Long id) {

		return bodyMapper.getById(id);
	}

	@DELETE
	@Path("/{id}")
	public String deleteEngine(@PathParam("id") Long id) {
		bodyMapper.remove(id);
		return "ok";
	}
}
