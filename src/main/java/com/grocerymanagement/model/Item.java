package com.grocerymanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "item",cascade = {CascadeType.MERGE,CascadeType.PERSIST},orphanRemoval = true,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Order> orders=new ArrayList<>();

    private String name;
    private double price;
    private Integer units;


}
