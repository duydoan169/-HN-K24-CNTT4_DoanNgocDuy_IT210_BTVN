package com.example.session6.repository;

import com.example.session6.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        courses.add(new Course("IELTS-6.5", "IELTS 6.5", "Intermediate", 5000000, "Lộ trình IELTS", "Mr.A", 3, 10, false, "2026-05-01"));
        courses.add(new Course("IELTS-8.0", "IELTS 8.0", "Advanced", 8000000, "Lộ trình nâng cao", "Mr.B", 4, 0, false, "2026-06-01"));
        courses.add(new Course("BASIC-ENG", "Basic English", "Beginner", 3000000, "Cơ bản", "Ms.C", 2, 20, true, "2026-04-20"));
        courses.add(new Course("TOEIC-650", "TOEIC 650+", "Intermediate", 4200000, "TOEIC mục tiêu 650+", "Ms.D", 3, 0, false, "2026-05-15"));
        courses.add(new Course("KIDS-A1", "Kids A1", "Beginner", 2500000, "Tiếng Anh thiếu nhi", "Mr.E", 2, 5, false, "2026-04-25"));
    }

    public boolean updateCourse(Course updated) {
        Course existing = findByCode(updated.getCode());
        if (existing == null) return false;
        existing.setPrice(updated.getPrice());
        existing.setStartDate(updated.getStartDate());
        return true;
    }


    public List<Course> findAll() {
        return courses;
    }

    public Course findByCode(String code) {
        return courses.stream()
                .filter(c -> c.getCode().equals(code))
                .findFirst().orElse(null);
    }

    public void delete(String code) {
        courses.removeIf(c -> c.getCode().equals(code));
    }
}