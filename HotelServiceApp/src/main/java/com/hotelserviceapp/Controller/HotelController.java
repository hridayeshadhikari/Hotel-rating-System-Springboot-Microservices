package com.hotelserviceapp.Controller;

import com.hotelserviceapp.Entity.Hotel;
import com.hotelserviceapp.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/add")
    public ResponseEntity<Hotel> addNewHotel(@RequestBody Hotel hotel){
         Hotel hotel1=hotelService.addHotel(hotel);
         return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> findHotelById(@PathVariable Long hotelId){
        Hotel hotel=hotelService.getHotelById(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(hotel);
    }

    @GetMapping("allhotel")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotels=hotelService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(hotels);
    }
}
