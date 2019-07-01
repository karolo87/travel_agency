package com.travelagency.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Airport {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "departureAirport")
    private List<Trip> departureTripList;
    @OneToMany(mappedBy = "arrivalAirport")
    private List<Trip> arrivalTripList;
}
