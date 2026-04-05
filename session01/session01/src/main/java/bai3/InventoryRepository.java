package bai3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

// Inventory Repository
@Repository
class InventoryRepository {

    public int getStock(String foodName) {
        if (foodName.equals("Mì xào bò")) {
            return 0; // hết hàng
        }
        return 10;
    }
}

// User Account Repository
@Repository
class UserAccountRepository {

    public double getBalance(String username) {
        return 5000;
    }

    public void deductMoney(String username, double amount) {
        System.out.println("Trừ " + amount + " từ tài khoản " + username);
    }
}

// Service
@Service
class OrderFoodService {
    private InventoryRepository inventoryRepository;
    private UserAccountRepository userAccountRepository;
    @Autowired
    public OrderFoodService(InventoryRepository inventoryRepository,
                            UserAccountRepository userAccountRepository) {
        this.inventoryRepository = inventoryRepository;
        this.userAccountRepository = userAccountRepository;
    }
    public void orderFood(String username, String foodName, double price) {
        int stock = inventoryRepository.getStock(foodName);
        double balance = userAccountRepository.getBalance(username);
        if (stock <= 0) {
            System.out.println("Món " + foodName + " đã hết hàng");
            return;
        }
        if (balance < price) {
            System.out.println("Tài khoản không đủ tiền");
            return;
        }
        userAccountRepository.deductMoney(username, price);
        System.out.println("Đặt món " + foodName + " thành công cho " + username);
    }
}