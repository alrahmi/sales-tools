package com.rahmi.BuildCar.util.deserializer;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import com.rahmi.BuildCar.controller.EngineMapper;
import com.rahmi.BuildCar.model.Engine;
import com.rahmi.BuildCar.util.EjbApplicationClient;

public class EngineDeserializer extends JsonDeserializer<Engine> {
	 

	    @Override
	    public Engine deserialize(JsonParser jp, DeserializationContext arg) throws IOException, JsonProcessingException {
	        String id = jp.getText();
	        return EjbApplicationClient.doLookup(EngineMapper.class).getById(Long.parseLong(id));
	    }
}
