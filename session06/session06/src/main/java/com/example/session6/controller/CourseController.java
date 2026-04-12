package com.example.session6.controller;

import com.example.session6.model.Course;
import com.example.session6.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("/list")
    public String list(
            @RequestParam(name = "level", defaultValue = "ALL") String level,
            @RequestParam(name = "price", required = false) Double price,
            Model model
    ) {
        List<Course> list = service.filter(level, price);

        model.addAttribute("courses", list);
        model.addAttribute("level", level);
        model.addAttribute("price", price);

        if (list.isEmpty()) {
            model.addAttribute("emptyMessage", "Hiện chưa có lớp học phù hợp với trình độ này");
        }

        return "course/list";
    }

    @GetMapping("/detail/{code}")
    public String detail(@PathVariable("code") String code, Model model, RedirectAttributes ra) {
        Course c = service.findByCode(code);
        if (c == null) {
            ra.addFlashAttribute("error", "Không tìm thấy khóa học");
            return "redirect:/course/list";
        }
        model.addAttribute("course", c);
        return "course/detail";
    }

    @GetMapping("/edit/{code}")
    public String edit(@PathVariable("code") String code, Model model, RedirectAttributes ra) {
        Course c = service.findByCode(code);
        if (c == null) {
            ra.addFlashAttribute("error", "Không tìm thấy khóa học");
            return "redirect:/course/list";
        }
        model.addAttribute("course", c);
        return "course/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("course") Course course, RedirectAttributes ra) {
        boolean ok = service.updateCourse(course);
        ra.addFlashAttribute(ok ? "success" : "error",
                ok ? "Cập nhật khóa học thành công" : "Cập nhật thất bại");
        return "redirect:/course/list";
    }

    @PostMapping("/delete/{code}")
    public String delete(@PathVariable("code") String code, RedirectAttributes ra) {
        boolean ok = service.deleteCourse(code);
        if (!ok) {
            ra.addFlashAttribute("error", "Không thể hủy khóa học đã có học viên đăng ký");
        } else {
            ra.addFlashAttribute("success", "Đã hủy khóa học thành công");
        }
        return "redirect:/course/list";
    }
}
