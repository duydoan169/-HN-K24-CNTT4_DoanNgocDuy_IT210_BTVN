package com.example.session6.service;

import com.example.session6.model.Course;
import com.example.session6.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public List<Course> filter(String level, Double maxPrice) {
        return repo.findAll().stream()
                .filter(c -> level.equals("ALL") || c.getLevel().equalsIgnoreCase(level))
                .filter(c -> maxPrice == null || c.getPrice() <= maxPrice)
                .toList();
    }

    public Course findByCode(String code) {
        return repo.findByCode(code);
    }

    public boolean updateCourse(Course course) {
        return repo.updateCourse(course);
    }

    public boolean deleteCourse(String code) {
        Course c = repo.findByCode(code);
        if (c == null) return false;
        if (c.getStudentCount() > 0) return false;
        repo.delete(code);
        return true;
    }

}
