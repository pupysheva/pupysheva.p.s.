package ru.mirea.ksp_lab1_pet_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mirea.ksp_lab1_pet_service.ServiceElements.Item;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private ItemService p;
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
}
