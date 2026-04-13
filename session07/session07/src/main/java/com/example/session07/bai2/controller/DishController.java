package com.example.session07.bai2.controller;

import com.example.session07.bai2.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/merchant/dish")
public class DishController {

    @ModelAttribute("categories")
    public List<String> getCategories() {
        return Arrays.asList("Món chính", "Đồ uống", "Tráng miệng", "Topping");
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("dish", new Dish());
        return "dish-add";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        Dish dish = new Dish();
        dish.setName("Trà sữa");
        dish.setCategory("Đồ uống");

        model.addAttribute("dish", dish);
        return "dish-edit";
    }

    @GetMapping("/search")
    public String showSearchPage() {
        return "dish-search";
    }
}
