package bai1;

//public class RechargeService {
//    private PaymentGateway gateway;
//
//    public RechargeService() {
//        // Lỗi: Hard-code dependency
//        this.gateway = new InternalPaymentGateway();
//    }
//
//    public void recharge(String username, double amount) {
//        gateway.pay(amount);
//        System.out.println("User " + username + " recharge " + amount);
//    }
//}

/*
Vấn đề của đoạn code
RechargeService tự khởi tạo InternalPaymentGateway
Phụ thuộc trực tiếp vào implementation cụ thể
Vi phạm nguyên lý Inversion of Control (IoC) và Loose Coupling
Khó mở rộng khi thêm Momo, ZaloPay hoặc cổng thanh toán mới

Thiết kế hiện tại gây khó khăn trong việc mở rộng hệ thống và bảo trì
Cần sử dụng Dependency Injection của Spring để inject PaymentGateway từ bên ngoài,
giúp hệ thống linh hoạt và dễ mở rộng hơn.
*/
