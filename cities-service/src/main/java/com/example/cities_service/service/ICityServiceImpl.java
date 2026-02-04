package com.example.cities_service.service;

import com.example.cities_service.Dto.CityDTO;
import com.example.cities_service.model.City;
import com.example.cities_service.repository.IHotelApi;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ICityServiceImpl implements ICityService {

    private final IHotelApi hotelApi;
    List<City> cities = new ArrayList<>();


    public ICityServiceImpl(IHotelApi hotelApi) {
        this.hotelApi = hotelApi;
    }

    @Override
    @CircuitBreaker(name="hotels-service", fallbackMethod = "fallbackMethodHotels")
    @Retry(name="hotels-service")
    public CityDTO getCitiesHotels(String name, String country) {
        City city = this.findCity(name,country);

        CityDTO cityDTO = new CityDTO();
        cityDTO.setCity_id(city.getCity_id());
        cityDTO.setName(city.getName());
        cityDTO.setCountry(city.getCountry());
        cityDTO.setContinent(city.getContinent());
        cityDTO.setState(city.getState());

        cityDTO.setHotelList(this.hotelApi.getHotelsByCityId(city.getCity_id()));


        return cityDTO;
    }

    public CityDTO fallbackMethodHotels(String name, String country, Throwable throwable) {
        return new CityDTO(999999999999999999L, "failed", "failed", "failed", "failed", null);
    }

    public void createException(){
        throw new IllegalStateException("This is a test exception");
    }

    public City findCity(String name,String country){
        this.loadCities();

        for (City city : this.cities) {
            if (city.getName().equals(name)
                    && city.getCountry().equals(country)) {
                return city;
            }
        }

        return null;
    }

    public void loadCities(){

        this.cities.add(new City(1L, "Buenos aires", "sout america", "argentina", "buenos aires"));
        this.cities.add(new City(2L, "Obera", "sout america", "argentina", "Misiones"));
        this.cities.add(new City(3L, "Mexico city", "north america", "mexico", "Mexico  city"));
    }
}
