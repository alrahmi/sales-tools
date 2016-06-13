package com.rahmi.BuildCar.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rahmi.BuildCar.model.Car;
import com.rahmi.BuildCar.service.CarJSPService;

@WebServlet(name = "CarServlet", urlPatterns = "/CarServlet")
public class CarServlet {
	@EJB
	CarJSPService dao;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Car car = new Car();
		car.setId(id);
		car.setName(name);
		if ("creat".equalsIgnoreCase(action)) {
			dao.createCar(car);

		} else if ("name".equalsIgnoreCase(action)) {
			dao.getById(id);
		}
		request.setAttribute("car", dao.getAllCar());
	}
}
