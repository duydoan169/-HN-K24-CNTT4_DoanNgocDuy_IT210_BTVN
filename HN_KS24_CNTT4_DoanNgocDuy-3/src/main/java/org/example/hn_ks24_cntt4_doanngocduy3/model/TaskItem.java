package org.example.hn_ks24_cntt4_doanngocduy3.model;

import java.time.LocalDate;

public class TaskItem {
    private String id;
    private String title;
    private LocalDate deadline;
    private String priority;

    public TaskItem() {
    }

    public TaskItem(String id, String title, LocalDate deadline, String priority) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
