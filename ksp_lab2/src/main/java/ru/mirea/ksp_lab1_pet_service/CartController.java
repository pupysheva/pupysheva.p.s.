package ru.mirea.ksp_lab1_pet_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mirea.ksp_lab1_pet_service.ServiceElements.Cart;
import ru.mirea.ksp_lab1_pet_service.ServiceElements.Item;

import java.util.List;

@Controller
public class CartController {

    private CartService cs;

    @Autowired
    CartController(CartService cs) {
        this.cs = cs;
    }
    
    @RequestMapping(value = "cart/{pet_or_Stuff}/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public List<Cart> cart_putItem(@PathVariable int id, @PathVariable String pet_or_Stuff) {
        return cs.putItem_inCart(id, pet_or_Stuff);
    }

    @RequestMapping(value = "cart/item/{item_id}", method = RequestMethod.DELETE)
    @ResponseBody
    public List<Cart> cart_deleteItem(@PathVariable int item_id) {
        return cs.deleteItem_inCart(item_id);
    }

    @RequestMapping(value = "cart", method = RequestMethod.GET)
    @ResponseBody
    public List<Cart> cart_getCart() {
        return cs.getCart();
    }
}

