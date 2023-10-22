package hr.kingict.springbootakademija2023.mapper;

import com.amadeus.resources.FlightOfferSearch;
import hr.kingict.springbootakademija2023.dto.FlightSearchDto;
import org.springframework.stereotype.Component;

@Component
public class FlightOfferSearchFlightSearchDtoMapper {
    
    public FlightSearchDto map(FlightOfferSearch flightOfferSearch){
        if(flightOfferSearch == null){
            return null;
        }
        
        FlightSearchDto flightSearchDto = new FlightSearchDto();
        
        FlightOfferSearch.Itinerary outboundItinerary = flightOfferSearch.getItineraries()[0];
        FlightOfferSearch.Itinerary inboundItinerary = flightOfferSearch.getItineraries()[1];
        
        //outbound data
        FlightOfferSearch.SearchSegment outboundDepartureSegment = outboundItinerary.getSegments()[0];
        FlightOfferSearch.SearchSegment outboundArrivalSegment = outboundItinerary.getSegments()[1];

        flightSearchDto.setOutboundDepartureAirport(outboundDepartureSegment.getDeparture().getIataCode());
        flightSearchDto.setOutboundDepartureDate(outboundDepartureSegment.getDeparture().getAt());

        flightSearchDto.setOutboundArrivalAirport(outboundArrivalSegment.getArrival().getIataCode());
        flightSearchDto.setOutboundArrivalDate(outboundArrivalSegment.getArrival().getAt());

        flightSearchDto.setOutboundCarrier(outboundArrivalSegment.getCarrierCode());

        //inbound data
        FlightOfferSearch.SearchSegment inboundDepartureSegment = inboundItinerary.getSegments()[0];
        FlightOfferSearch.SearchSegment inboundArrivalSegment = inboundItinerary.getSegments()[1];

        flightSearchDto.setInboundDepartureAirport(inboundDepartureSegment.getDeparture().getIataCode());
        flightSearchDto.setInboundDepartureDate(inboundDepartureSegment.getDeparture().getAt());

        flightSearchDto.setInboundArrivalAirport(inboundArrivalSegment.getArrival().getIataCode());
        flightSearchDto.setInboundArrivalDate(inboundArrivalSegment.getArrival().getAt());

        flightSearchDto.setInboundCarrier(inboundArrivalSegment.getCarrierCode());
        
        flightSearchDto.setPrice(flightOfferSearch.getPrice().getTotal());

        return flightSearchDto;
    }
}
