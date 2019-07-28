package com.travelagency.demo.service;

import com.travelagency.demo.domain.model.PurchaseFinanceDetails;
import com.travelagency.demo.domain.model.TripPurchase;
import com.travelagency.demo.domain.repository.PurchaseFinanceDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseFinanceDetailsService {

    private final PurchaseFinanceDetailsRepository financeDetailsRepository;

    public PurchaseFinanceDetails save(TripPurchase tripPurchase) {
        PurchaseFinanceDetails purchaseFinanceDetails = new PurchaseFinanceDetails();

        purchaseFinanceDetails.setAdultsCost(calculateAdultsCost(tripPurchase));
        purchaseFinanceDetails.setChildrenCost(calculateChildrenCost(tripPurchase));
        purchaseFinanceDetails.setTotalCost(calculateTotalCost(tripPurchase));
        purchaseFinanceDetails.setTripPurchase(tripPurchase);
        tripPurchase.setFinanceDetails(purchaseFinanceDetails);
        return financeDetailsRepository.save(purchaseFinanceDetails);
    }


    private Double calculateAdultsCost(TripPurchase tripPurchase) {

        Integer adultsQuantity = tripPurchase.getAdultsQuantity();
        double adultPrice = tripPurchase.getTrip().getAdultPrice();
        return adultsQuantity * adultPrice;

    }

    private Double calculateChildrenCost(TripPurchase tripPurchase) {
            Integer childrenQuantity = tripPurchase.getChildrenQuantity();
            double childPrice = tripPurchase.getTrip().getChildPrice();
            return childrenQuantity * childPrice;
    }

    private Double calculateTotalCost(TripPurchase tripPurchase) {
            return calculateAdultsCost(tripPurchase) + calculateChildrenCost(tripPurchase);
     }


}
