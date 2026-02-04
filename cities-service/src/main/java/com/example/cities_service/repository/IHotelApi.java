package com.example.cities_service.repository;


import com.example.cities_service.Dto.HotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//DATO: Ingresar el nombre de la app en eureka para que lo indentifique.
//para evitar configurar la url.
@FeignClient(name="hotels-service")
public interface IHotelApi {

    @GetMapping("hotels/{city_id}")
    public List<HotelDto> getHotelsByCityId(@PathVariable("city_id") Long city_id);
}
