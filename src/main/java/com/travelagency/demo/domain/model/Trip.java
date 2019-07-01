package com.travelagency.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    private City departureCity;
    @ManyToOne
    private Airport departureAirport;
    @ManyToOne
    private City arrivalCity;
    @ManyToOne
    private Airport arrivalAirport;
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