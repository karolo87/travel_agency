package com.travelagency.demo.domain.repository;

import com.travelagency.demo.domain.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
