package com.travelagency.demo.dto;

import com.travelagency.demo.domain.model.Airport;
import com.travelagency.demo.domain.model.City;

import lombok.Data;

@Data
public class TripDto {

    private Long id;
    private String departureCity;
    private String departureAirport;
    private String arrivalCity;
    private String arrivalAirport;
    private String hotel;
    private String startDate;
    private String endDate;
    private Integer daysQuantity;
    private String type;    //BB, HB, FB, AI
    private double adultPrice;
    private double childPrice;
    // promowana ????
    private Integer adultsQuantity;
    private Integer childrenQuantity;
}
