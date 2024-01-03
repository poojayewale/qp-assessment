package com.grocerymanagement.service;

import com.grocerymanagement.dao.OrderDao;
import com.grocerymanagement.exception.InsufficientInventory;
import com.grocerymanagement.model.Item;
import com.grocerymanagement.model.Order;
import com.grocerymanagement.model.OrderRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    GroceryService groceryService;

    public void placeOrder(List<OrderRequestDto> orderRequestDtos, String userId){
        List<Item> items = new ArrayList<>();
        Map<Long,Long> qtyMap=new HashMap<>();
        for (OrderRequestDto orderRequestDto : orderRequestDtos) {
            Item item = groceryService.getGroceryById(orderRequestDto.getItemId());
            if (item != null && item.getUnits() >= orderRequestDto.getQuantity()) {
                items.add(item);
                qtyMap.put(orderRequestDto.getItemId(),orderRequestDto.getQuantity());
            }
            else{
                throw new InsufficientInventory("Insufficient inventory", HttpStatus.BAD_REQUEST);
            }
        }

        for (Item item : items) {
            Order order = new Order();
            order.setItem(item);
            order.setUserId(userId);
            orderDao.save(order);
            item.setUnits(item.getUnits() - qtyMap.get(item.getId()).intValue());
            groceryService.updateItem(item);
        }

    }
}
