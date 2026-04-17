package org.example.hn_ks24_cntt4_doanngocduy3.controller;

import jakarta.validation.Valid;
import org.example.hn_ks24_cntt4_doanngocduy3.dto.TaskItemDTO;
import org.example.hn_ks24_cntt4_doanngocduy3.model.TaskItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class TaskController {
    List<TaskItem> taskItems = new ArrayList<>(
            Arrays.asList(
                    new TaskItem("TI01", "task 1", LocalDate.of(2026, 8, 15), "HIGH"),
                    new TaskItem("TI02", "task 2", LocalDate.of(2026, 9, 16), "MEDIUM"),
                    new TaskItem("TI03", "task 3", LocalDate.of(2026, 10, 17), "LOW")
            )
    );

    @GetMapping("/tasks")
    public String taskList(Model model){
        model.addAttribute("taskItems", taskItems);
        return "task-list";
    }

    @GetMapping("/tasks/addPage")
    public String addForm(Model model){
        model.addAttribute("task", new TaskItem());
        return "task-form";
    }

    @PostMapping("/tasks/add")
    public String addTask(@Valid @ModelAttribute("task") TaskItemDTO dto,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("task", dto);
            return "task-form";
        }

        TaskItem newTask = new TaskItem(
                dto.getId(),
                dto.getTitle(),
                dto.getDeadline(),
                dto.getPriority()
        );

        taskItems.add(newTask);

        return "redirect:/tasks";
    }

}
