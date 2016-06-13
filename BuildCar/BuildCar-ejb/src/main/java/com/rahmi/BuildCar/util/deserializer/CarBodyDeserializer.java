package com.rahmi.BuildCar.util.deserializer;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import com.rahmi.BuildCar.controller.BodyMapper;
import com.rahmi.BuildCar.model.CarBody;
import com.rahmi.BuildCar.util.EjbApplicationClient;


public class CarBodyDeserializer extends JsonDeserializer<CarBody> {
	 

    @Override
    public CarBody deserialize(JsonParser jp, DeserializationContext arg) throws IOException
    , JsonProcessingException {
        String id = jp.getText();
        return EjbApplicationClient.doLookup(BodyMapper.class).getById(Long.parseLong(id));
    }
}
