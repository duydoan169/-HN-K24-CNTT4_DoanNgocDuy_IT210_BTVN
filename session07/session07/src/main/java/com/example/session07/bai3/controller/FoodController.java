package com.example.session07.bai3.controller;

import com.example.session07.bai3.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
                          Model model) {

        if (file.isEmpty()) {
            model.addAttribute("error", "Bạn chưa chọn ảnh.");
            return "food-add";
        }

        if (food.getPrice() < 0) {
            model.addAttribute("error", "Giá tiền phải lớn hơn hoặc bằng 0.");
            return "food-add";
        }

        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.isBlank()) {
            model.addAttribute("error", "Tên file không hợp lệ.");
            return "food-add";
        }

        String lowerName = originalFilename.toLowerCase();
        if (!(lowerName.endsWith(".jpg") || lowerName.endsWith(".jpeg") || lowerName.endsWith(".png"))) {
            model.addAttribute("error", "Chỉ chấp nhận file .jpg, .jpeg, .png.");
            return "food-add";
        }

        try {
            File folder = new File(UPLOAD_DIR);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = UUID.randomUUID() + extension;

            File destination = new File(folder, newFileName);
            file.transferTo(destination);

            food.setImagePath(destination.getAbsolutePath());
            FOODS.add(food);

            System.out.println("=== THÊM MÓN THÀNH CÔNG ===");
            System.out.println("Tên món: " + food.getName());
            System.out.println("Danh mục: " + food.getCategory());
            System.out.println("Giá: " + food.getPrice());
            System.out.println("Ảnh: " + food.getImagePath());
            System.out.println("Tổng số món: " + FOODS.size());

            model.addAttribute("success", "Thêm món ăn thành công.");
            model.addAttribute("food", new Food());
            return "food-add";

        } catch (IOException e) {
            model.addAttribute("error", "Lỗi khi lưu file.");
            return "food-add";
        }
    }
}