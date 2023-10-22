package hr.kingict.springbootakademija2023.controller;

import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import hr.kingict.springbootakademija2023.dto.FlightSearchDto;
import hr.kingict.springbootakademija2023.dto.LocationDto;
import hr.kingict.springbootakademija2023.form.FlightSearchForm;
import hr.kingict.springbootakademija2023.mapper.FlightOfferSearchFlightSearchDtoMapper;
import hr.kingict.springbootakademija2023.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class FlightController {
    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightOfferSearchFlightSearchDtoMapper flightSearchDtoMapper;

    @GetMapping(value = "/airports/{keyword}")
    public ResponseEntity<List<LocationDto>> getAirports(@PathVariable String keyword){
        List<Location> airports = flightService.getAirports(keyword);

        List<LocationDto> listAirportsDto = airports.stream()
                .map(location -> new LocationDto(location.getName(), location.getDetailedName(), location.getIataCode()))
                .toList();

        return ResponseEntity
                .ok()
                .body(listAirportsDto);
    }

    @PostMapping(value = "/flights")
    public ResponseEntity<List<FlightSearchDto>> getFlights(@RequestBody @Valid FlightSearchForm flightSearchForm){
        List<FlightOfferSearch> flights = flightService.getFlights(flightSearchForm.getOriginLocationCode(),
                flightSearchForm.getDestinationLocationCode(),
                flightSearchForm.getDepartureDate(),
                flightSearchForm.getReturnDate(),
                flightSearchForm.getAdults());

        return ResponseEntity
                .ok()
                .body(flights
                        .stream()
                        .map(flightOfferSearch -> flightSearchDtoMapper.map(flightOfferSearch))
                        .toList());
    }
}
