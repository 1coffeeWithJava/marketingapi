package com.marketing.payload;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class MarketDto {

    private Long id;

    private String title;

    private String brand;

    private String category;

    @Size(min = 1, max = 10, message = "it should be in the range")
    private double price;

    @Size(min = 1, max = 10, message = "it should be in the range")
    private double stock;
}
