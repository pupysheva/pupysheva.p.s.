package ru.mirea.ksp_lab1_pet_service;
import org.springframework.stereotype.Service;
import ru.mirea.ksp_lab1_pet_service.ServiceElements.Item;

import java.util.*;

@Service
public class ItemService {
    public List<Item> getPets(){
        List<Item> pets = new LinkedList<Item>();
        Item dog = new Item(1, "dog", "pet",4);
        Item cat = new Item(2, "cat", "pet", 3);
        pets.add(dog);
        pets.add(cat);
        return pets;
    }

    public List<Item> getStuffs(){
        List<Item> stuffs = new LinkedList<Item>();
        Item qwe = new Item(1, "123", "stuff",4);
        Item ewq = new Item(2, "321", "stuff", 3);
        stuffs.add(qwe);
        stuffs.add(ewq);
        return stuffs;
    }
}