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

import com.rahmi.BuildCar.controller.EngineMapper;
import com.rahmi.BuildCar.model.Engine;
import com.rahmi.BuildCar.util.filter.EngineRequestForm;

@Path("/rest/xml/engine")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class ResourceRestXMLEngineService {
	
	@EJB
	private EngineMapper engineMapper;

	@GET
	@Path("/")
	public List<Engine> getListAllEngine(@Form EngineRequestForm form) {
		return engineMapper.getAll(form);
	}

	@GET
	@Path("/{id}")
	public Engine getEngineByID(@PathParam("id") Long id) {

		return engineMapper.getById(id);
	}

}
