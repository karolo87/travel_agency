package com.travelagency.demo.domain.repository;

import com.travelagency.demo.domain.model.ClientsData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsDataRepository extends JpaRepository<ClientsData, Long> {

}
