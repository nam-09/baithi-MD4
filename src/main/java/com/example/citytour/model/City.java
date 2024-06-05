package com.example.citytour.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double area;
    private Long population;
    private Double GDP;
    private String description;

    @ManyToOne
    public Country country;

}
