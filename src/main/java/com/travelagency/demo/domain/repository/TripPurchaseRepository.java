package com.travelagency.demo.domain.repository;

import com.travelagency.demo.domain.model.ClientsData;
import com.travelagency.demo.domain.model.TripPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripPurchaseRepository extends JpaRepository<TripPurchase, Long> {

}
