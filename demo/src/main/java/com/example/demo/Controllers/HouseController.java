package com.example.demo.Controllers;

import com.example.demo.Entities.House;

import com.example.demo.Entities.User;
import com.example.demo.Service.HouseService;
import com.example.demo.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class HouseController {

    private final HouseService houseService;
    private final UserService userService; //

    public HouseController(HouseService houseService, UserService userService) {
        this.houseService = houseService;
        this.userService = userService; // Инъекция userService
    }

    @GetMapping("/houses")
    public String findAll(Model model){
        List<House> houses = houseService.findAll();
        model.addAttribute("houses" , houses);
        return "house-list";
    }

    @GetMapping("/house-create")
    public String createHouseForm(House house, Model model){
        List<User> users = userService.findAll(); //  список пользователей
        model.addAttribute("users", users);
        return "house-create";
    }



    @PostMapping("/house-create")
    public String createHouse(House house){
        houseService.saveHouse(house);
        return "redirect:/houses";
    }

    @GetMapping("house-delete/{id}")
    public String deleteHouse(@PathVariable("id") Long id){
        houseService.deleteById(id);
        return "redirect:/houses";
    }

    @GetMapping("/house-update/{id}")
    public String updateHouseForm(@PathVariable("id") Long id, Model model){
        House house = houseService.findById(id);
        model.addAttribute("house", house);
        model.addAttribute("users", userService.findAll());
        return "house-update";
    }

    @PostMapping("/house-update")
    public String updateHouse(House house){
        houseService.saveHouse(house);
        return "redirect:/houses";
    }
}
