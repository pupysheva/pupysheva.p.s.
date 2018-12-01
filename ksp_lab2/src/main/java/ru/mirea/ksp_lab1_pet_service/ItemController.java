package ru.mirea.ksp_lab1_pet_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mirea.ksp_lab1_pet_service.ServiceElements.Item;
import ru.mirea.ksp_lab1_pet_service.dao.ItemDAO;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private ItemDAO p;
    @RequestMapping(value = "item", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> items(){
        return p.getAll();
    }
    /*
    @RequestMapping(value = "pet", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> pets(){
        return p.getPets();
    }

    @RequestMapping(value = "stuff", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> stuffs(){
        return p.getStuffs();
    }

    @RequestMapping(value = "pet/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Item petId(@PathVariable int id){
        return p.getPets(id);
    }

    @RequestMapping(value = "stuff/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Item stuffId(@PathVariable int id){
        return p.getStuffs(id);
    }
    @RequestMapping(value = "item/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Item itemId(@PathVariable int id){
        return p.getItems(id);
    }*/
}
