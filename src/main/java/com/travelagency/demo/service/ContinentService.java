package com.travelagency.demo.service;

import com.travelagency.demo.domain.model.Continent;
import com.travelagency.demo.domain.repository.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ContinentService {

    private ContinentRepository continentRepository;

    @Autowired
    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    public Continent addNewContinent(Continent continent){
        return continentRepository.save(continent);
    }

    public Optional<Continent> getContinentById(Long id) {
        return continentRepository.findById(id);
    }

    public List<Continent> getAllContinentsSortedByName(){
        List<Continent> continents = continentRepository.findAll();
        continents.sort(Comparator.comparing(Continent::getName));
        return continents;
    }
}
