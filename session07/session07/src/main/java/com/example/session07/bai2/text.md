# Phân tích và sửa lỗi lặp code trong `DishController`

## Phần 1 - Phân tích logic

### 1. Đoạn code hiện tại vi phạm nguyên tắc nào?

Việc lặp lại đoạn:

List<String> categories = Arrays.asList("Món chính", "Đồ uống", "Tráng miệng", "Topping");
model.addAttribute("categories", categories);

ở nhiều method đang vi phạm nguyên tắc:

DRY (Don't Repeat Yourself)

Nghĩa là không nên lặp lại cùng một logic ở nhiều nơi.

### 2. Rủi ro bảo trì nếu sau này có 20 trang cùng dùng danh sách này

Nếu sau này hệ thống có 20 trang đều cần danh sách categories, thì sẽ phát sinh các vấn đề:

Phải copy-paste cùng một đoạn code ở rất nhiều method
Khi cần sửa danh sách nhóm món ăn, phải sửa ở nhiều nơi
Rất dễ sót 1 vài chỗ, làm dữ liệu giữa các trang không đồng nhất
Controller bị phình to, khó đọc, khó bảo trì
Tăng nguy cơ bug do cập nhật không đồng bộ