package hr.kingict.springbootakademija2023.controller;

import com.amadeus.resources.Location;
import hr.kingict.springbootakademija2023.dto.LocationDto;
import hr.kingict.springbootakademija2023.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class FlightController {
    @Autowired
    private FlightService flightService;
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
}
