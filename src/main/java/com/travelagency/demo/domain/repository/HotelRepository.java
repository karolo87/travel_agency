package com.travelagency.demo.domain.repository;

import com.travelagency.demo.domain.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findAllByCity_Id(Long id);
    Hotel findByNameContaining(String name);
}
