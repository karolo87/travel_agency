package com.travelagency.demo.domain.repository;

import com.travelagency.demo.domain.model.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepository extends JpaRepository<Continent, Long> {
}
