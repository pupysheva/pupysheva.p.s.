package ru.mirea.ksp_lab1_pet_service.ServiceElements;

import java.util.LinkedList;
import java.util.List;

public class Cart {

    /*private List<Item> items = new LinkedList<Item>();
    public Cart(List<Item> items) {
        this.items = items;
    }
    public List<Item> getItems() { return items;}
    */

    private int id;
    private int user_id;
    private int item_id;
    private boolean status;

    public Cart(int id, int user_id, int item_id, boolean status) {
        this.id = id;
        this.user_id = user_id;
        this.item_id = item_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public boolean isStatus() {
        return status;
    }
}
