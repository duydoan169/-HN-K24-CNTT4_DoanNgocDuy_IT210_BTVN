package com.example.session07.bai5.controller;

import com.example.session07.bai5.model.Combo;
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
@RequestMapping("/combos")
public class ComboController {

    private static final String UPLOAD_DIR = "C:/RikkeiFood_Temp/";
    private static final List<Combo> COMBOS = new ArrayList<>();

    @ModelAttribute("foods")
    public List<String> getFoods() {
        return Arrays.asList(
                "Gà rán",
                "Pizza",
                "Hamburger",
                "Khoai tây chiên",
                "Coca Cola",
                "Trà sữa",
                "Mỳ Ý"
        );
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("combo", new Combo());
        return "combo-add";
    }

    @PostMapping("/add")
    public String addCombo(@ModelAttribute("combo") Combo combo,
                           @RequestParam("image") MultipartFile banner,
                           Model model) {

        if (combo.getItemList() == null || combo.getItemList().size() < 2) {
            model.addAttribute("error", "Combo phải có ít nhất 2 món.");
            return "combo-add";
        }

        if (banner == null || banner.isEmpty()) {
            model.addAttribute("error", "Bạn phải chọn banner cho combo.");
            return "combo-add";
        }

        String originalFilename = banner.getOriginalFilename();
        if (originalFilename == null || originalFilename.isBlank()) {
            model.addAttribute("error", "Tên file banner không hợp lệ.");
            return "combo-add";
        }

        String lowerName = originalFilename.toLowerCase();
        if (!(lowerName.endsWith(".jpg") || lowerName.endsWith(".jpeg") || lowerName.endsWith(".png"))) {
            model.addAttribute("error", "Banner chỉ chấp nhận file .jpg, .jpeg, .png.");
            return "combo-add";
        }

        try {
            File folder = new File(UPLOAD_DIR);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String uniqueName = UUID.randomUUID() + extension;

            File dest = new File(folder, uniqueName);
            banner.transferTo(dest);

            combo.setBannerPath(dest.getAbsolutePath());
            COMBOS.add(combo);

            System.out.println("=== COMBO JSON ===");
            System.out.println(toJson(combo));
            System.out.println("Tổng số combo: " + COMBOS.size());

            model.addAttribute("success", "Tạo combo thành công.");
            model.addAttribute("combo", new Combo());
            return "combo-add";

        } catch (IOException e) {
            model.addAttribute("error", "Lỗi khi lưu banner.");
            return "combo-add";
        }
    }

    private String toJson(Combo combo) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  \"name\": \"").append(escape(combo.getName())).append("\",\n");
        sb.append("  \"price\": ").append(combo.getPrice()).append(",\n");
        sb.append("  \"itemList\": [");

        if (combo.getItemList() != null) {
            for (int i = 0; i < combo.getItemList().size(); i++) {
                sb.append("\"").append(escape(combo.getItemList().get(i))).append("\"");
                if (i < combo.getItemList().size() - 1) {
                    sb.append(", ");
                }
            }
        }

        sb.append("],\n");
        sb.append("  \"bannerPath\": \"").append(escape(combo.getBannerPath())).append("\"\n");
        sb.append("}");
        return sb.toString();
    }

    private String escape(String value) {
        if (value == null) {
            return "";
        }
        return value.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}