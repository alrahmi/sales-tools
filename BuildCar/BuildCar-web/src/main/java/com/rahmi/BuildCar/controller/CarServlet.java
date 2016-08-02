package com.rahmi.BuildCar.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rahmi.BuildCar.model.Car;
import com.rahmi.BuildCar.model.CarBody;
import com.rahmi.BuildCar.model.Engine;
import com.rahmi.BuildCar.model.Transmission;
import com.rahmi.BuildCar.util.filter.CarRequestForm;

@WebServlet(name = "CarServlet", urlPatterns = "/CarServlet")
public class CarServlet {
	@EJB
	CarMapper dao;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");

		Transmission transmission = new Transmission();
		Engine engine = new Engine();
		CarBody body = new CarBody();
		Car car = new Car();
		car.setId(id);
		car.setName(name);
		car.setEngine(engine);
		car.setTransmission(transmission);
		car.setBody(body);
		if ("create".equalsIgnoreCase(action)) {
		} else if ("name".equalsIgnoreCase(action)) {
			dao.getById(id);
			
		}
		request.setAttribute("car", dao.getAll(new CarRequestForm()));
	}
}
