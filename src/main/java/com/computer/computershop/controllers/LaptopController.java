package com.computer.computershop.controllers;
import com.computer.computershop.entities.Laptops;
import com.computer.computershop.payload.LaptopDto;
import com.computer.computershop.services.LaptopServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// API LAYER TO HANDLE HTTP REQUEST FROM CLIENT LAYER
@Controller
public class LaptopController {

    private LaptopServiceImpl laptopServiceImpl;

    public LaptopController(LaptopServiceImpl laptopServiceImpl) {
        this.laptopServiceImpl = laptopServiceImpl;
    }

    //  TO GET ALL LAPTOPS FROM DATABASE
    @GetMapping("/laptop")
    public String getListLaptops(Model model){
        LaptopDto laptopDto = new LaptopDto();
        model.addAttribute("laptopsList", laptopServiceImpl.getAllLaptops());
        model.addAttribute("adding",  laptopDto);
        return "laptopList";
    }

    // TO ADD NEW LAPTOP TO OUR DATABASE
    @PostMapping("/laptop/add/{id}")
    public String addLaptopToList(@ModelAttribute("adding") LaptopDto laptopDto, @PathVariable Long id){
        Integer amountLaptop = laptopDto.getAmountLaptop();
        Laptops laptopById = laptopServiceImpl.getLaptopById(id);
        laptopById.setNumber(laptopById.getNumber()+amountLaptop);
        laptopServiceImpl.addLaptops(laptopById);
        return "redirect:/laptop";
    }

    // TO GET LAPTOP PAGE TO ADD NEW OBJECT
    @GetMapping("/laptop/new")
    public String createLaptopForm(Model model){
        Laptops laptops = new Laptops();
        model.addAttribute("laptops", laptops);
        return "example";
    }

    // THIS POST MAPPING TO ADD NEW OBJECTS
    @PostMapping("/laptop")
    public String addLaptop(@ModelAttribute("laptops") Laptops laptops){
        laptopServiceImpl.addLaptops(laptops);
        return "redirect:/laptop";
    }

    @GetMapping("/info/{id}")
    public String getPageInfoLaptop(@PathVariable Long id, Model model){
        model.addAttribute("laptopById", laptopServiceImpl.getLaptopById(id));
        return "info_about_laptop";
    }

    @GetMapping("/laptop/sale/{id}")
    public String getSalePage(@PathVariable Long id, Model model){
        model.addAttribute("saleLaptopByID", laptopServiceImpl.getLaptopById(id));
        LaptopDto laptopSale = new LaptopDto();
        model.addAttribute("laptopDto", laptopSale);
        return "sale_laptop";
//        laptopServiceImpl.getLaptopById(id)
    }

    @PostMapping("/laptop/sale/{id}")
    public String saleLaptop(@ModelAttribute("saleLaptopById") LaptopDto laptopDto, @PathVariable Long id, Model model){
        Integer amountLaptop = laptopDto.getAmountLaptop();

        Laptops laptopById = laptopServiceImpl.getLaptopById(id);
        laptopById.setNumber(laptopById.getNumber()-amountLaptop);
        addLaptop(laptopById);

        return "redirect:/laptop";

    }

    @GetMapping("/delete/{id}")
    public String deleteLaptop(@PathVariable Long id){
            laptopServiceImpl.deleteLaptop(id);
         return "laptopList";
    }
}
