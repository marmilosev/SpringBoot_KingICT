package hr.kingict.springbootakademija2023.service;

import com.amadeus.Amadeus;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import com.amadeus.Params;
import com.amadeus.referencedata.Locations;
import hr.kingict.springbootakademija2023.entity.FlightSearchEntity;
import hr.kingict.springbootakademija2023.mapper.FlightOfferSearchFlightSearchResultEntityMapper;
import hr.kingict.springbootakademija2023.repository.FlightSearchRepository;
import hr.kingict.springbootakademija2023.repository.FlightSearchResultRepository;
import jakarta.transaction.Transactional;
import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private Amadeus amadeus;
    @Autowired
    private FlightSearchRepository flightSearchRepository;
    @Autowired
    private FlightSearchResultRepository flightSearchResultRepository;

    private FlightOfferSearchFlightSearchResultEntityMapper flightSearchResultEntityMapper;

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

    @Transactional //metoda koja pretražuje u bazi i radi nešto s time
    public List<FlightOfferSearch> getFlights(String originLocationCode, String destinationLocationCode, LocalDate departureDate, LocalDate returnDate, Integer adults){

        List<FlightSearchEntity> byFlight = flightSearchRepository.findByFlight(originLocationCode, destinationLocationCode, departureDate, returnDate, adults);

        FlightSearchEntity flightSearchEntity = new FlightSearchEntity();
        if(byFlight == null || byFlight.isEmpty()) {
            flightSearchEntity.setOriginLocationCode(originLocationCode);
            flightSearchEntity.setDestinationLocationCode(destinationLocationCode);
            flightSearchEntity.setDepartureDate(departureDate);
            flightSearchEntity.setReturnDate(returnDate);
            flightSearchEntity.setAdults(adults);

            flightSearchEntity.setUserCreated("Marija");
            flightSearchEntity.setDateCreated(LocalDate.now());

            flightSearchRepository.save(flightSearchEntity);
        }

        Params params = Params
                .with("originLocationCode", originLocationCode)
                .and("destinationLocationCode", destinationLocationCode)
                .and("departureDate", departureDate.toString())
                .and("returnDate", returnDate.toString())
                .and("adults", adults)
                .and("nonStop", true)
                .and("max", 10);

        try {
            FlightOfferSearch[] flightOfferSearches = amadeus.shopping.flightOffersSearch.get(params);
            Arrays.asList(flightOfferSearches)
                    .stream()
                    .map(flightOfferSearch -> flightSearchResultEntityMapper.map(flightOfferSearch))
                    .forEach(flightSearchResultEntity ->{
                        flightSearchResultEntity.setFlightSearchEntity(flightSearchEntity);
                        flightSearchResultRepository.save(flightSearchResultEntity);
                    });
            return Arrays.asList(flightOfferSearches);
        } catch (Exception e) {
            logger.error("getFlights error : " + e.getMessage(), e);
        }

        return Collections.emptyList();
    }
}
