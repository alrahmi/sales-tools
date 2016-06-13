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

import com.rahmi.BuildCar.controller.TransMapper;
import com.rahmi.BuildCar.model.Transmission;
import com.rahmi.BuildCar.util.filter.TransmissionRequestForm;

@Path("/rest/xml/transmission")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class ResourceRestXMLTransmissionService {

	

	@EJB
	private TransMapper transMapper;

	@GET
	@Path("/")
	public List<Transmission> getListAllTransmission(@Form TransmissionRequestForm form) {
		return transMapper.getAll(form);
	}

	@GET
	@Path("/{id}")
	public Transmission getTransmissionByID(@PathParam("id") Long id) {
		return transMapper.getById(id);
	}
}
