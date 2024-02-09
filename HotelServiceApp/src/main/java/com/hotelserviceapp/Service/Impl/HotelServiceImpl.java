package com.hotelserviceapp.Service.Impl;

import com.hotelserviceapp.Entity.Hotel;
import com.hotelserviceapp.Exception.ResourceNotFoundException;
import com.hotelserviceapp.Repository.HotelRepository;
import com.hotelserviceapp.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("no hotel found with given id"));
    }
}
