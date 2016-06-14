package com.rahmi.BuildCar.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rahmi.BuildCar.model.CarBody;
import com.rahmi.BuildCar.service.CarBodyJSPService;
import com.rahmi.BuildCar.util.filter.CarBodyRequestForm;

@WebServlet(name = "CarBodyServlet", urlPatterns = "/CarBodyServlet")
public class CarBodyServlet {
	@EJB
	BodyMapper dao;

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
		if ("create".equalsIgnoreCase(action)) {
			dao.create(body);
		} else if ("update".equalsIgnoreCase(action)) {
			dao.update(id, body);

		} else if ("getById".equalsIgnoreCase(action)) {
			dao.getById(id);
		}

		request.setAttribute("body", dao.getAll(new CarBodyRequestForm()));
	}
}
