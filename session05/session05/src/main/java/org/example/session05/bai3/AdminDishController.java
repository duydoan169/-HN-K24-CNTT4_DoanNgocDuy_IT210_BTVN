package org.example.session05.bai3;

import org.example.session05.bai2.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/bai3")
public class AdminDishController {

    @Autowired
    private AdminDishService adminDishService;

    @GetMapping("/dishes")
    public String list(Model model) {
        model.addAttribute("dishes", adminDishService.getAll());
        return "dish-list";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        return adminDishService.findById(id)
                .map(dish -> {
                    model.addAttribute("dish", dish);
                    return "edit-dish";
                })
                .orElseGet(() -> {
                    ra.addFlashAttribute("error", "Không tìm thấy món ăn yêu cầu!");
                    return "redirect:/bai3/dishes";
                });
    }

    @PostMapping("/edit")
    public String updateDish(@ModelAttribute("dish") Dish dish,
                             RedirectAttributes ra) {

        boolean ok = adminDishService.update(dish);

        if (ok) {
            ra.addFlashAttribute("success", "Cập nhật món ăn thành công!");
        } else {
            ra.addFlashAttribute("error", "Cập nhật món ăn thất bại!");
        }

        return "redirect:/bai3/dishes";
    }
}