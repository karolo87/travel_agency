package com.travelagency.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TripPurchase {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @OneToOne
    private Trip trip;
    @OneToOne(mappedBy = "tripPurchase")
    private ClientsData client;
    private Integer adultsQuantity;
    private Integer childrenQuantity;
}
