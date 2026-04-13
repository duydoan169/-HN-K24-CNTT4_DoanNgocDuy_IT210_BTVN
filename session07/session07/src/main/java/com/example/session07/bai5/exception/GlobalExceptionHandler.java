package com.example.session07.bai5.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public String handleIllegalStateException(IllegalStateException ex,
                                              HttpServletRequest request,
                                              Model model) {

        String message = ex.getMessage();

        if (message != null && message.toLowerCase().contains("exceeds maximum size")) {
            model.addAttribute("error", "File quá lớn. Vui lòng chọn file không quá 10MB.");
            model.addAttribute("path", request.getRequestURI());
            return "upload-error";
        }

        model.addAttribute("error", "Đã xảy ra lỗi: " + ex.getMessage());
        model.addAttribute("path", request.getRequestURI());
        return "upload-error";
    }
}