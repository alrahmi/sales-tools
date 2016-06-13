package com.rahmi.BuildCar.util.deserializer;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import com.rahmi.BuildCar.controller.TransMapper;
import com.rahmi.BuildCar.model.Transmission;
import com.rahmi.BuildCar.util.EjbApplicationClient;

public class TransmissionDeserializer extends JsonDeserializer<Transmission> {
	 

    @Override
    public Transmission deserialize(JsonParser jp, DeserializationContext arg) throws IOException, JsonProcessingException {
        String id = jp.getText();
        return EjbApplicationClient.doLookup(TransMapper.class).getById(Long.parseLong(id));
    }
}
