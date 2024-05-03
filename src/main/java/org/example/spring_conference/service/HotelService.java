package org.example.spring_conference.service;

import org.example.spring_conference.model.Hotel;
import org.example.spring_conference.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> saveAll(List<Hotel> hotels) {
        return hotelRepository.saveAll(hotels);
    }
}
