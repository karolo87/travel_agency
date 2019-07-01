package com.travelagency.demo.domain.repository;

import com.travelagency.demo.domain.model.Continent;
import com.travelagency.demo.domain.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

    public List<Country> findAllByContinent_Id(Long id);


}
