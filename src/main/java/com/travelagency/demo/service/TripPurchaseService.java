package com.travelagency.demo.service;

import com.travelagency.demo.domain.model.ClientsData;
import com.travelagency.demo.domain.model.Trip;
import com.travelagency.demo.domain.model.TripPurchase;
import com.travelagency.demo.domain.repository.TripPurchaseRepository;
import com.travelagency.demo.dto.TripPurchaseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripPurchaseService {

    private final TripPurchaseRepository tripPurchaseRepository;
    private final  TripService tripService;
    private final ClientsDataService clientsDataService;

    public void addNewTripPurchase(Long tripId, TripPurchase tripPurchase) {
        Optional<Trip> foundTrip = tripService.getTripById(tripId);
        foundTrip.ifPresent(tripPurchase::setTrip);
        tripPurchaseRepository.save(tripPurchase);
    }

    public TripPurchase createPurchaseFromDto(Long tripId, TripPurchaseDto tripPurchaseDto) {
        Optional<Trip> foundTrip = tripService.getTripById(tripId);
        TripPurchase tripPurchase = new TripPurchase();
        ClientsData clientsData = new ClientsData();
        clientsData.setFirstName(tripPurchaseDto.getClientFirstName());
        clientsData.setLastName(tripPurchaseDto.getClientLastName());

        clientsData = clientsDataService.addNewClient(clientsData);

        tripPurchase.setClient(clientsData);
        tripPurchase.setAdultsQuantity(tripPurchaseDto.getAdultsQuantity());
        tripPurchase.setChildrenQuantity(tripPurchaseDto.getChildrenQuantity());
        foundTrip.ifPresent(tripPurchase::setTrip);

        if (foundTrip.isPresent()) {
            foundTrip.get()
                    .setAdultsQuantity(foundTrip.get().getAdultsQuantity() - tripPurchaseDto.getAdultsQuantity());
            foundTrip.get()
                    .setChildrenQuantity(foundTrip.get().getChildrenQuantity() - tripPurchaseDto.getChildrenQuantity());
        }

        return tripPurchaseRepository.save(tripPurchase);
    }

    public Optional<TripPurchase> getTripPurchaseById(Long id) {
        return tripPurchaseRepository.findById(id);
    }

    public Double calculateTripPurchaseFinances(Long tripPurchaseId) {
        Optional<TripPurchase> foundTrip = getTripPurchaseById(tripPurchaseId);
        if (foundTrip.isPresent()) {
            Integer childrenQuantity = foundTrip.get().getChildrenQuantity();
            double childPrice = foundTrip.get().getTrip().getChildPrice();

            Integer adultsQuantity = foundTrip.get().getAdultsQuantity();
            double adultPrice = foundTrip.get().getTrip().getAdultPrice();

            Double amount = (childrenQuantity * childPrice) + (adultsQuantity * adultPrice);
            return amount;
        }
        return null;
    }

}
