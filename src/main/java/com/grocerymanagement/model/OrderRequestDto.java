package com.grocerymanagement.model;

import lombok.Data;

@Data
public class OrderRequestDto {
    private Long itemId;
    private Long quantity;
}
