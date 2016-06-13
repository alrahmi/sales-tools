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

import com.rahmi.BuildCar.controller.EngineMapper;
import com.rahmi.BuildCar.model.Engine;
import com.rahmi.BuildCar.util.filter.EngineRequestForm;

@Path("/rest/json/engine")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResourceRestEngineService {
	
	@EJB
	private EngineMapper engineMapper;

	@GET
	@Path("/")
	public List<Engine> getListAllEngine(@Form EngineRequestForm form) {
		return engineMapper.getAll(form);
	}

	@POST
	@Path("/")
	public Engine createEngine(Engine engine) {
		engineMapper.create(engine);
		return engine;
	}

	@PUT
	@Path("/{id}")
	public Engine updateEngine(@PathParam("id") Long id, Engine engine) {
		engineMapper.refresh(engine);
		return engine;
	}

	@GET
	@Path("/{id}")
	public Engine getEngineByID(@PathParam("id") Long id) {

		return engineMapper.getById(id);
	}

	@DELETE
	@Path("/{id}")
	public String deleteEngine(@PathParam("id") Long id) {
		engineMapper.remove(id);
		return "ok";
	}

}
