package ru.mirea.ksp_lab1_pet_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.ksp_lab1_pet_service.ServiceElements.Item;

import java.util.*;

@Service
public class ItemService {

    private List<Item> items;
    public ItemService() {
        this.items = new LinkedList<>();
    }

    /*public ItemService() {
        this.items = new LinkedList<Item>();
        this.items.add(new Item(1, "dog", "pet",4));
        this.items.add(new Item(2, "cat", "pet", 3));
        this.items.add(new Item(3, "cat food", "stuff",4));
        this.items.add(new Item(4, "dog food", "stuff", 3));
    }*/
     public List<Item> getItems(){
        return items;
     }
    public Item getItems(int id){
        for(Item it : items)
            if(it.getId() == id)
                return it;
        return null;
    }

    public List<Item> getPets() {
        List<Item> pets = new LinkedList<Item>();
        for (int i = 0; i < items.size(); i++)
            if (items.get(i).getType().equals("pet")) pets.add(items.get(i));
        return pets;
    }

    public List<Item> getStuffs() {
        List<Item> stuffs = new LinkedList<>();
        for (Item st : items)
            if (st.getType().equals("stuff"))
                stuffs.add(st);
        return stuffs;
    }

    public Item getPets(int id) {
        for (Item pet : getPets())
            if (pet.getId() == id)
                return pet;
        return null;
    }

    public Item getStuffs(int id) {
        for (int i = 0; i < items.size(); i++)
            if (items.get(i).getId() == id)
                return items.get(i);
        return null;
    }
}