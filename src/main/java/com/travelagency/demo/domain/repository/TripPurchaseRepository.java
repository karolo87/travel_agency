package com.travelagency.demo.domain.repository;

import com.travelagency.demo.domain.model.TripPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripPurchaseRepository extends JpaRepository<TripPurchase, Long> {

}
