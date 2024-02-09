package com.hotelserviceapp.Repository;

import com.hotelserviceapp.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
