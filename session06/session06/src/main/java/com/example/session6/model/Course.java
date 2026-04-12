package com.example.session6.model;

public class Course {
    private String code;
    private String name;
    private String level;
    private double price;
    private String description;
    private String teacher;
    private int duration;
    private int studentCount;
    private boolean isFull;
    private String startDate;

    public Course(String code, String name, String level, double price, String description, String teacher, int duration, int studentCount, boolean isFull, String startDate) {
        this.code = code;
        this.name = name;
        this.level = level;
        this.price = price;
        this.description = description;
        this.teacher = teacher;
        this.duration = duration;
        this.studentCount = studentCount;
        this.isFull = isFull;
        this.startDate = startDate;
    }

    public String getCode() {
        return code;
    }

    public Course() {
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getDuration() {
        return duration;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public boolean isFull() {
        return isFull;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
