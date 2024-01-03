package com.grocerymanagement.dao;

import com.grocerymanagement.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<Item,Long> {
}
