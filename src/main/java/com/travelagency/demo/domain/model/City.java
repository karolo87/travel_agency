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
public class City {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String city;
    @ManyToOne
    private Country country;
    @OneToMany(mappedBy = "city")
    private List<Airport> airportList;
    @OneToMany(mappedBy = "city")
    private List<Hotel> hotelList;
    @OneToMany(mappedBy = "departureCity")
    private List<Trip> departureTripList;
    @OneToMany(mappedBy = "arrivalCity")
    private List<Trip> arrivalTripList;
}
