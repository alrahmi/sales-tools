package com.rahmi.BuildCar.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.rahmi.BuildCar.controller.EngineMapper;
import com.rahmi.BuildCar.model.Engine;

//The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class CreaterService {
	 @Inject
	    private Logger log;

	    @Inject
	    private EntityManager em;
	    @Inject 
	    Engine engine;
	    @Inject
	    EngineMapper engineMapper;
	    public Engine createEngine(Engine engine){	
		 em.persist(engine);
	    return engine;	
	    }
}
