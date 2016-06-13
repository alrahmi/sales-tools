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

@WebServlet(name = "EngineServlet", urlPatterns = "/EngineServlet")
public class EngineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	EngineJSPService dao;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		Long id = Long.parseLong(request.getParameter("id"));
		String type = request.getParameter("type");
		Float volume = Float.parseFloat(request.getParameter("volume"));
		double power = Double.parseDouble(request.getParameter("power"));
		String serialNumber = request.getParameter("serialNumber");
		Engine engine = new Engine();
		engine.setId(id);
		engine.setType(type);
		engine.setVolume(volume);
		engine.setPower(power);
		engine.setSerialNumber(serialNumber);

		if ("create".equalsIgnoreCase(action)) {
			dao.createEngine(engine);
		} else if ("update".equalsIgnoreCase(action)) {
			dao.updateEngine(engine);
		} else if ("delete".equalsIgnoreCase(action)) {
			dao.deleteEngine(id);
		} else if ("getById".equalsIgnoreCase(action)) {
			dao.getById(id);
		} else if ("getAll".equalsIgnoreCase(action)) {
			dao.getAllEngine();
		}
		request.setAttribute("engine", engine);
		request.setAttribute("All engines", dao.getAllEngine());

	}

}
