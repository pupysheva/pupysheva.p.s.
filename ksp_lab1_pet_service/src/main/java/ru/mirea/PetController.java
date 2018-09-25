package ru.mirea;
import java.util.List;

@Controller
public class PetController {
    @RequestMappinf(value = "pet", method = RequestMethod.GET)
    @ResponceBody
    public List<Pet> pets(){return petService.pets()}
}
