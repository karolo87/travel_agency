package com.travelagency.demo.dto;

import lombok.Data;

@Data
public class TripPurchaseDto {

    private String purchaseId;
    private String clientFirstName;
    private String clientLastName;
    private Integer adultsQuantity;
    private Integer childrenQuantity;
}
