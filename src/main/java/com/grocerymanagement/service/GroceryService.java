package com.grocerymanagement.service;

import com.grocerymanagement.dao.ItemDao;
import com.grocerymanagement.model.GroceryRequestDto;
import com.grocerymanagement.model.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroceryService {

    @Autowired
    ItemDao itemDao;

    public List<Item> saveGroceryItems(List<GroceryRequestDto> groceryRequestDtos) {
        List<Item> groceryEntityList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for (GroceryRequestDto groceryRequestDto : groceryRequestDtos) {
            Item groceryEntity;
            try {
                JSONObject jsonObject=new JSONObject(groceryRequestDto);
                groceryEntity = objectMapper.readValue(jsonObject.toString(), Item.class);
                groceryEntityList.add(groceryEntity);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        return itemDao.saveAll(groceryEntityList);
    }

    public Item getGroceryById(Long id){
        return itemDao.findById(id).get();
    }

    public List<Item> findAllItems(){
        return itemDao.findAll();
    }

    public void deleteItems(Long id){
         itemDao.deleteById(id);
    }
    public void updateItem(Item item) {
        Item oldItem=itemDao.getById(item.getId());
        oldItem.setUnits(item.getUnits());
        oldItem.setName(item.getName());
        oldItem.setPrice(item.getPrice());
        itemDao.save(oldItem);
    }

    public void updateInventory(Long id, Integer quantity){
        Item item=itemDao.getById(id);
        item.setUnits(quantity);
        itemDao.save(item);

    }
}
