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

import com.rahmi.BuildCar.controller.TransMapper;
import com.rahmi.BuildCar.model.Transmission;
import com.rahmi.BuildCar.util.filter.TransmissionRequestForm;

@Path("/rest/json/transmission")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResourceRestTransmissionService {
	
	
	@EJB
	private TransMapper transMapper;

	@GET
	@Path("/")
	public List<Transmission> getListAllTransmission(@Form TransmissionRequestForm form) {
		return transMapper.getAll(form);
	}

	@POST
	@Path("/")
	public Transmission createTransmission(Transmission transmission) {
		transMapper.create(transmission);
		return transmission;
	}

	@PUT
	@Path("/{id}")
	public Transmission updateTransmission(@PathParam("id") Long id, Transmission transmission) {
		transMapper.refresh(transmission);
		return transmission;
	}

	@GET
	@Path("/{id}")
	public Transmission getTransmissionByID(@PathParam("id") Long id) {

		return transMapper.getById(id);
	}

	@DELETE
	@Path("/{id}")
	public String deleteTransmission(@PathParam("id") Long id) {
		transMapper.remove(id);
		return "ok";
	}
}
