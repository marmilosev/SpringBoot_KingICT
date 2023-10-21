package hr.kingict.springbootakademija2023.service;

import com.amadeus.Amadeus;
import com.amadeus.resources.Location;
import com.amadeus.Params;
import com.amadeus.referencedata.Locations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private Amadeus amadeus;
    Logger logger = LoggerFactory.getLogger(FlightService.class);
    public List<Location> getAirports(String keyword){
        Params params = Params
                .with("subType", Locations.AIRPORT)
                .and("keyword", keyword);
        try {
            Location[] locations = amadeus.referenceData.locations.get(params);
            return Arrays.asList(locations);
        }catch (Exception e){
            logger.error("getAirport error", e);

            return Collections.emptyList();
        }
    }
}
