package bai5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*SystemConfig Chức năng: Định nghĩa Bean cấu hình hệ thống Sử dụng @Component để Spring quản lý
Sử dụng @Value để gán giá trị mặc định
 */
@Component
public class SystemConfig {
    // Tên chi nhánh
    @Value("Cyber Gaming PTIT")
    private String branchName;
    // Giờ mở cửa
    @Value("08:00 AM")
    private String openingHour;

    public String getBranchName() {
        return branchName;
    }

    public String getOpeningHour() {
        return openingHour;
    }
}