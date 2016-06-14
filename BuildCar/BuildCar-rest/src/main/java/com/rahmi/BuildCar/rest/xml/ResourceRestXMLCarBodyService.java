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

import com.rahmi.BuildCar.controller.BodyMapper;
import com.rahmi.BuildCar.model.CarBody;
import com.rahmi.BuildCar.util.filter.CarBodyRequestForm;


@Path("/xml/carBody")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class ResourceRestXMLCarBodyService {
	
	@EJB
	private BodyMapper bodyMapper;

	@GET
	@Path("/")
	public List<CarBody> getListAllCarBody(@Form CarBodyRequestForm form) {
		return bodyMapper.getAll(form);
	}

	@GET
	@Path("/{id}")
	public CarBody getCarBodyByID(@PathParam("id") Long id) {

		return bodyMapper.getById(id);
	}

}
