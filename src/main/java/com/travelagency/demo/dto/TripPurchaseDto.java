package com.travelagency.demo.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TripPurchaseDto {

    private String purchaseId;
    private String clientFirstName;
    private String clientLastName;
    private String adultsQuantity;
    private String childrenQuantity;
    private String adultsAvailable;
    private String childrenAvailable;


}
