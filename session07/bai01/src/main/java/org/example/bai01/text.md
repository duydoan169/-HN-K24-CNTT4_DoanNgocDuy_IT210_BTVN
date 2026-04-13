# Phân tích lỗi Data Binding trong Spring MVC

## 1. Lỗi: Tên cửa hàng bị null

### Nguyên nhân
Trong class Java:

```java
private String name;

Nhưng trong HTML:

<input type="text" name="restaurantName" />

Spring Data Binding hoạt động dựa trên tên thuộc tính (field name).

Spring sẽ tìm setter tương ứng với restaurantName
Trong class không có field restaurantName
Do đó không bind được dữ liệu
Kết quả
profile.getName() == null
2. Lỗi: Checkbox active không hoạt động đúng
Nguyên nhân

Trong Java:

private boolean active;

Trong HTML:

<input type="checkbox" name="active" value="MỞ_CỬA" />
Vấn đề
active là kiểu boolean
Checkbox lại gửi giá trị "MỞ_CỬA" (String)
Spring không thể convert "MỞ_CỬA" → boolean

Ngoài ra:

Nếu checkbox không tick → không gửi param
Dễ gây sai lệch dữ liệu
Kết luận
Sai kiểu dữ liệu (String vs boolean)
Không đúng chuẩn Data Binding của Spring