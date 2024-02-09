package com.hotelserviceapp.Service;

import com.hotelserviceapp.Entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel addHotel(Hotel hotel);
    List<Hotel> getAll();
    Hotel getHotelById(Long hotelId);
}
