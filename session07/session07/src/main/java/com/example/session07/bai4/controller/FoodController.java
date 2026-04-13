package com.example.session07.bai4.controller;

import com.example.session07.bai3.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/foods")
public class FoodController {

    private static final String UPLOAD_DIR = "C:/RikkeiFood_Temp/";
    private static final List<Food> FOODS = new ArrayList<>();

    @ModelAttribute("categories")
    public List<String> getCategories() {
        return Arrays.asList("Khai vị", "Món chính", "Đồ uống", "Tráng miệng");
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("food", new Food());
        return "food-add";
    }

    @PostMapping("/add")
    public String addFood(@ModelAttribute("food") Food food,
                          @RequestParam("image") MultipartFile file,
                          RedirectAttributes redirectAttributes,
                          Model model) {

        if (file.isEmpty()) {
            model.addAttribute("error", "Chưa chọn ảnh.");
            return "food-add";
        }

        if (food.getPrice() < 0) {
            model.addAttribute("error", "Giá phải >= 0");
            return "food-add";
        }

        String originalName = file.getOriginalFilename();
        if (originalName == null || originalName.isBlank()) {
            model.addAttribute("error", "Tên file không hợp lệ");
            return "food-add";
        }

        String lower = originalName.toLowerCase();
        if (!(lower.endsWith(".jpg") || lower.endsWith(".png") || lower.endsWith(".jpeg"))) {
            model.addAttribute("error", "Chỉ chấp nhận ảnh jpg/png/jpeg");
            return "food-add";
        }

        try {
            File folder = new File(UPLOAD_DIR);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String extension = originalName.substring(originalName.lastIndexOf("."));
            String newFileName = System.currentTimeMillis() + "_" + UUID.randomUUID() + extension;

            File dest = new File(folder, newFileName);
            file.transferTo(dest);

            food.setImagePath(dest.getAbsolutePath());
            FOODS.add(food);

            int index = FOODS.size() - 1;

            System.out.println("=== ADD FOOD SUCCESS ===");
            System.out.println(food.getName());
            System.out.println("Total: " + FOODS.size());

            redirectAttributes.addFlashAttribute("success", "Thêm món thành công!");

            return "redirect:/foods/detail?id=" + index;

        } catch (IOException e) {
            model.addAttribute("error", "Lỗi lưu file");
            return "food-add";
        }
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam("id") int id,
                             Model model) {

        if (id < 0 || id >= FOODS.size()) {
            model.addAttribute("error", "Không tìm thấy món");
            return "food-detail";
        }

        model.addAttribute("food", FOODS.get(id));
        return "food-detail";
    }
}