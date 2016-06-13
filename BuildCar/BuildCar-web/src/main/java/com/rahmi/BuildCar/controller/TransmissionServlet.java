package com.rahmi.BuildCar.controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.rahmi.BuildCar.model.Transmission;
import com.rahmi.BuildCar.service.TransmissionJSPService;

@WebServlet(name = "TransmissionServlet", urlPatterns = "/TransmissionServlet")
public class TransmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	TransmissionJSPService dao;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		long id = Long.parseLong(request.getParameter("id"));
		String type = request.getParameter("type");
		String serialNumber = request.getParameter("serialNumber");
		Transmission transmission = new Transmission();
		transmission.setId(id);
		transmission.setType(type);
		transmission.setSerialNumber(serialNumber);
		if ("creat".equalsIgnoreCase(action)) {

			dao.createTransmission(transmission);

		} else if ("update".equalsIgnoreCase(action)) {
			dao.updateTransmission(transmission);

		} else if ("delete".equalsIgnoreCase(action)) {
			dao.deleteTransmission(id);
		} else if ("getByid".equalsIgnoreCase(action)) {
			dao.getById(id);

		} else if ("getAll".equalsIgnoreCase(action)) {
			dao.getAllTransmission();
		}
		request.setAttribute("transmission", transmission);
		request.setAttribute("All transmissions", dao.getAllTransmission());
	}
}
