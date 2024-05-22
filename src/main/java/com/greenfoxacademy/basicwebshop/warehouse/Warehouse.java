package com.greenfoxacademy.basicwebshop.warehouse;

import com.greenfoxacademy.basicwebshop.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<Item> warehouse;

    public Warehouse() {
        this.warehouse = new ArrayList<>();
        this.warehouse.add(new Item("BMW","SUV", "530D", 500, 0));
        this.warehouse.add(new Item("Skoda and NIKE","cabrio", "Octavia", 100, 11));
        this.warehouse.add(new Item("Honda", "track","staff and Nike and staff", 2000, 3));
    }

    public List<Item> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(List<Item> warehouse) {
        this.warehouse = warehouse;
    }
    public void addItem(Item item){
        warehouse.add(item);
    }
}