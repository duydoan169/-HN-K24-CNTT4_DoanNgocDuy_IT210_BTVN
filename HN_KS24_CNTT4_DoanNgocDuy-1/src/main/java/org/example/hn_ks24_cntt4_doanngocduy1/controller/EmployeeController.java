package org.example.hn_ks24_cntt4_doanngocduy1.controller;

import org.example.hn_ks24_cntt4_doanngocduy1.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Nguyen Van An", "Dao tao", 8000));
        employees.add(new Employee(2, "Tran Thi Bich", "Dao tao", 12000));
        employees.add(new Employee(3, "Le Minh Chau", "Dao tao", 15000));
        employees.add(new Employee(4, "Pham Quoc Dat", "Dao tao", 5000));

        model.addAttribute("employees", employees);
        return "employee-list";
    }
}