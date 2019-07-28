package com.travelagency.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseFinanceDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Double adultsCost;
    private Double childrenCost;
    private Double totalCost;
    @OneToOne
    private TripPurchase tripPurchase;

}
