package com.travelagency.demo.service;

import com.travelagency.demo.domain.model.City;
import com.travelagency.demo.domain.model.Country;
import com.travelagency.demo.domain.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private CityRepository cityRepository;
    private CountryService countryService;

    @Autowired
    public CityService(CityRepository cityRepository,
                       CountryService countryService) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
    }

    public void addNewCity(Long countryId, City city) {
        Optional<Country> foundCountry = countryService.getCountryById(countryId);
        foundCountry.ifPresent(city::setCountry);
        cityRepository.save(city);
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public List<City> getAllCitiesOfGivenCountry(Long countryId) {
        return cityRepository.findAllByCountry_Id(countryId);
    }

    public Optional<City> findCityById(Long id) {
        return cityRepository.findById(id);
    }

    public City findCityByName(String name) {
        return cityRepository.findByNameContaining(name);
    }
}
