package com.example.cities_service.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class HotelDto {
    private Long id;
    private String name;
    private int start;
    private Long city_id;
}
