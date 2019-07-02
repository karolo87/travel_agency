package com.travelagency.demo.service;

import com.travelagency.demo.domain.model.City;
import com.travelagency.demo.domain.model.Hotel;
import com.travelagency.demo.domain.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private HotelRepository hotelRepository;
    private CityService cityService;

    @Autowired
    public HotelService(HotelRepository hotelRepository, CityService cityService) {
        this.hotelRepository = hotelRepository;
        this.cityService = cityService;
    }

    public Hotel addNewHotel(Long cityId, Hotel hotel){
        Optional<City> foundCity = cityService.findCityById(cityId);
        foundCity.ifPresent(hotel::setCity);
        return hotelRepository.save(hotel);
    }

    public List<Hotel> findHotelsByCityId(Long cityId) {
        return hotelRepository.findAllByCity_Id(cityId);
    }
}
