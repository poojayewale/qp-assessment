package com.grocerymanagement.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="customer_order")
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

}
