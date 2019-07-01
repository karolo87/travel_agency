package com.travelagency.demo.service;

import com.travelagency.demo.domain.model.Country;
import com.travelagency.demo.domain.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country addNewCountry(Country country){

        return countryRepository.save(country);
    }
}
