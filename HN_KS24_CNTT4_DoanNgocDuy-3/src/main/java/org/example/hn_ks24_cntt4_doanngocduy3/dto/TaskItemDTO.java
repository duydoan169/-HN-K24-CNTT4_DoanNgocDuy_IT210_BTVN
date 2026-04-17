package org.example.hn_ks24_cntt4_doanngocduy3.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public class TaskItemDTO {

    @NotBlank(message = "ID không được để trống")
    @Pattern(regexp = "^TI[0-9]+", message = "ID phải bắt đầu bằng TI và kết thúc bằng chữ số VD: TI01")
    private String id;

    @NotBlank(message = "Tên không được để trống")
    @Length(min = 5, message = "Độ dài tên phải trên 5 ký tự")
    private String title;

    @Future(message = "Deadline phải ở tương lai")
    private LocalDate deadline;

    @NotBlank(message = "Độ ưu tiên không được để trống")
    @Pattern(regexp = "^(HIGH|MEDIUM|LOW)$", message = "Độ ưu tiên phải là HIGH hoặc MEDIUM hoặc LOW")
    private String priority;

    public TaskItemDTO() {
    }

    public TaskItemDTO(String id, String title, LocalDate deadline, String priority) {
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
