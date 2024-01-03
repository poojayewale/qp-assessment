package com.grocerymanagement.model;

import lombok.Data;

@Data
public class GroceryRequestDto {
    private String name;
    private double price;
    private Integer units;
}
