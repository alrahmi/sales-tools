package com.rahmi.BuildCar.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rahmi.BuildCar.model.CarBody;
import com.rahmi.BuildCar.service.CarBodyJSPService;

@WebServlet(name = "CarBodyServlet", urlPatterns = "/CarBodyServlet")
public class CarBodyServlet {
	@EJB
	CarBodyJSPService doa;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String action = request.getParameter("action");
		String type = request.getParameter("type");
		String color = request.getParameter("color");
		int countOfDoors = Integer.parseInt(request.getParameter("countOfdoors"));
		String VIN = request.getParameter("VIN");
		CarBody body = new CarBody();
		body.setColor(color);
		body.setCountOfDoors(countOfDoors);
		body.setVIN(VIN);
		body.setType(type);
		if ("create".equalsIgnoreCase(action))
			doa.createCarBody(body);

		else if ("update".equalsIgnoreCase(action)) {
			doa.updateCarBody(body);

		} else if ("getById".equalsIgnoreCase(action)) {
			doa.getById(id);
		}
		request.setAttribute("carBody", body);
		request.setAttribute("All carBodys", doa.getAllCarBody());
	}
}
