package com.springbootapplication.h2demo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @Column(name = "item_number",unique=true, nullable = false)
    private String item_number;
    private String name;
    private Integer amount;
    private Integer inventory_code;

    public String getId() {
        return item_number;
    }

    public void setId(String item_number) {
        this.item_number = item_number;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getInventory_code() {
        return inventory_code;
    }

    public void setInventory_code(Integer inventory_code) {
        this.inventory_code = inventory_code;
    }
}
