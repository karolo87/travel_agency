package com.travelagency.demo.service;

import com.travelagency.demo.domain.model.Continent;
import com.travelagency.demo.domain.repository.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Continent> getAllContinents(){
        return continentRepository.findAll();
    }
}
