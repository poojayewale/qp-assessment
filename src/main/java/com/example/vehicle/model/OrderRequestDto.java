package com.example.vehicle.model;

import lombok.Data;

@Data
public class OrderRequestDto {
    private Long itemId;
    private Long quantity;
}
