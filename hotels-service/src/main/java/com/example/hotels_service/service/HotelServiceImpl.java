package com.example.hotels_service.service;


import com.example.hotels_service.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService {

    // Testeo
    List<Hotel> hotels = new ArrayList<Hotel>();

    @Override
    public List<Hotel> getHotelsByCityId(Long city_id) {
        List<Hotel> hotelArrayList = new ArrayList<>();

        this.loadHotels();

        for (Hotel hotel : hotels) {
            if(hotel.getCity_id() == city_id){
                hotelArrayList.add(hotel);
            }
        }

        return hotelArrayList;
    }

    public void loadHotels(){
        this.hotels.add(new Hotel(1l, "paradise", 5,1L));
        this.hotels.add(new Hotel(2l, "Sunset View", 4,2L));
        this.hotels.add(new Hotel(3l, "Ocean Breeze", 3,3L));
    }
}
