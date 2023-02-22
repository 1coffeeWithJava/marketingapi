package com.marketing.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "markets")
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String brand;

    private String category;

    private double price;

    private double stock;

    //title, brand, category, price(between min and max), stock(between min and max)
}
