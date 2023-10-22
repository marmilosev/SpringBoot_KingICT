package hr.kingict.springbootakademija2023.mapper;

import com.amadeus.resources.FlightOfferSearch;
import hr.kingict.springbootakademija2023.entity.FlightSearchEntity;
import hr.kingict.springbootakademija2023.entity.FlightSearchResultEntity;
import org.springframework.stereotype.Component;

@Component
public class FlightOfferSearchFlightSearchResultEntityMapper {

    public FlightSearchResultEntity map(FlightOfferSearch flightOfferSearch){
        if(flightOfferSearch == null){
            return null;
        }
        FlightSearchResultEntity flightSearchResultEntity = new FlightSearchResultEntity();

        FlightOfferSearch.Itinerary outboundItinerary = flightOfferSearch.getItineraries()[0];
        FlightOfferSearch.Itinerary inboundItinerary = flightOfferSearch.getItineraries()[1];

        //outbound data
        FlightOfferSearch.SearchSegment outboundSegment = outboundItinerary.getSegments()[0];

        //inbound data
        FlightOfferSearch.SearchSegment inboundSegment = inboundItinerary.getSegments()[0];

        flightSearchResultEntity.setPrice(flightOfferSearch.getPrice().getTotal());
        flightSearchResultEntity.setInboundCarrier(inboundSegment.getCarrierCode());
        flightSearchResultEntity.setOutboundCarrier(outboundSegment.getCarrierCode());

        return flightSearchResultEntity;
    }
}
