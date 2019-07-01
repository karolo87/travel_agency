package com.travelagency.demo.domain.repository;

import com.travelagency.demo.domain.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
