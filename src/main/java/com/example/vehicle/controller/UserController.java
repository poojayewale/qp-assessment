package com.example.vehicle.controller;

import com.example.vehicle.model.Item;
import com.example.vehicle.model.OrderRequestDto;
import com.example.vehicle.service.GroceryService;
import com.example.vehicle.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/grocery")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final GroceryService groceryService;

    @PostMapping("/order")
    public ResponseEntity<String> saveOrder(@RequestBody List<OrderRequestDto> orderRequestDtos, @RequestParam String userId)  {
        userService.placeOrder(orderRequestDtos,userId);
        return ResponseEntity.ok("Order placed successfully!");
    }

    @GetMapping("/viewGrocery")
    public ResponseEntity<List<Item>> viewGroceryItems(){
        List<Item> itemList=groceryService.findAllItems();
        return ResponseEntity.ok(itemList);
    }
}
