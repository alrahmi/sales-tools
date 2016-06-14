package com.rahmi.BuildCar.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rahmi.BuildCar.model.Engine;
import com.rahmi.BuildCar.service.EngineJSPService;
import com.rahmi.BuildCar.util.filter.EngineRequestForm;

@WebServlet(name = "EngineServlet", urlPatterns = "/EngineServlet")
public class EngineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	EngineMapper dao;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		Long id = request.getParameter("id") == null ? null : Long.parseLong(request.getParameter("id"));

		String type = request.getParameter("type");
		Float volume = Float.parseFloat(request.getParameter("volume"));
		double power = Double.parseDouble(request.getParameter("power"));
		String serialNumber = request.getParameter("serialNumber");
		Engine engine = new Engine();
		engine.setType(type);
		engine.setVolume(volume);
		engine.setPower(power);
		engine.setSerialNumber(serialNumber);

		if ("create".equalsIgnoreCase(action)) {
			dao.create(engine);
		} else if ("update".equalsIgnoreCase(action)) {
			dao.update(id, engine);
		} else if ("delete".equalsIgnoreCase(action)) {
			dao.remove(id);
		} else if ("getById".equalsIgnoreCase(action)) {
			dao.getById(id);
		} else if ("getAll".equalsIgnoreCase(action)) {
			dao.getAll(new EngineRequestForm());
		}
		request.setAttribute("engine", engine);
		request.setAttribute("engines", dao.getAll(new EngineRequestForm()));

	}

}
