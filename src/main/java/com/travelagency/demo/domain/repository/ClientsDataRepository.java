package com.travelagency.demo.domain.repository;

import com.travelagency.demo.domain.model.ClientsData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientsDataRepository extends JpaRepository<ClientsData, Long> {

    List<ClientsData> findAllByTripPurchaseId(Long tripPurchaseId);
}
