package bai5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/* Khởi tạo Spring Container  Lấy Bean SystemConfig */
public class Main {
    public static void main(String[] args) {
        // Khởi tạo Spring Container
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        // Lấy Bean
        SystemConfig config = context.getBean(SystemConfig.class);
        // In kết quả
        System.out.println("Tên chi nhánh: " + config.getBranchName());
        System.out.println("Giờ mở cửa: " + config.getOpeningHour());
    }
}