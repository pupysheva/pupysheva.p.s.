package ru.mirea.ksp_lab1_pet_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.ksp_lab1_pet_service.ServiceElements.Cart;
import ru.mirea.ksp_lab1_pet_service.ServiceElements.Item;

import java.util.LinkedList;
import java.util.List;

@Service
public class CartService {
    private List<Cart> cart;
    @Autowired
    private ItemService item_service;
    public CartService() {
        this.cart = new LinkedList<>();
    }

    public List<Cart> getCart() {
        return cart;
    }

    public Cart getElemCart(int item_id){
        for(Cart c : cart)
            if(c.getItem_id() == item_id)
                return c;
        return null;
    }

    List<Cart> putItem_inCart(int id, String pet_or_Stuff){
        if(id <= item_service.getItems().size()){
            Item adder = item_service.getItems(id);
            if(adder.getType().equals(pet_or_Stuff)) cart.add(new Cart(cart.size() + 1 ,16,adder.getId(),false));
            return cart;
        }
        else return cart;
    }
    List<Cart> deleteItem_inCart(int item_id){
        cart.remove(getElemCart(item_id));
        return cart;
    }
}
