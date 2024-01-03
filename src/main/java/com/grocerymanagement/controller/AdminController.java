package com.grocerymanagement.controller;

import com.grocerymanagement.model.GroceryRequestDto;
import com.grocerymanagement.model.Item;
import com.grocerymanagement.service.GroceryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/grocery")
@RequiredArgsConstructor
public class AdminController {

    private final GroceryService groceryService;

    @PostMapping("/addGrocery")
    public ResponseEntity<List<Item>> addGrocery(@RequestBody List<GroceryRequestDto> groceryRequestDto){
        return ResponseEntity.ok(groceryService.saveGroceryItems(groceryRequestDto));
    }

    @GetMapping("/viewGrocery")
    public ResponseEntity<List<Item>> viewGroceryItems(){
        return ResponseEntity.ok(groceryService.findAllItems());
    }

    @DeleteMapping("/deleteGrocery")
    public ResponseEntity<String> deleteGroceryItems(@RequestParam Long itemId){
        groceryService.deleteItems(itemId);
        return ResponseEntity.ok("Deleted item successfully");
    }

    @PutMapping("/updateGroceryItems")
    public ResponseEntity<String> updateGroceryItems(@RequestBody Item item){
        groceryService.updateItem(item);
        return ResponseEntity.ok("Updated item successfully");
    }

    @PutMapping("updateInventory")
    public ResponseEntity<String> updateInventory(@RequestParam Long itemId, @RequestParam Integer quantity){
        groceryService.updateInventory(itemId,quantity);
        return ResponseEntity.ok("Updated inventory successfully");
    }

}
