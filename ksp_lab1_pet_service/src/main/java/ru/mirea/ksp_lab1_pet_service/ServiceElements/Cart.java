package ru.mirea.ksp_lab1_pet_service.ServiceElements;

import java.util.LinkedList;
import java.util.List;

public class Cart {
    private List<Item> items = new LinkedList<Item>();

    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}
