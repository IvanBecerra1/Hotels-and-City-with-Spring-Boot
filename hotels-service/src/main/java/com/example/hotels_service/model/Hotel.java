package com.example.hotels_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Hotel {
    private Long id;
    private String name;
    private int start;
    private long city_id;

}
