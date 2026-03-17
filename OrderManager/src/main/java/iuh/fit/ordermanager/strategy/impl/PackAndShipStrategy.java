package iuh.fit.ordermanager.strategy.impl;

import iuh.fit.ordermanager.model.Order;
import iuh.fit.ordermanager.strategy.OrderHandlingStrategy;

/**
 * PackAndShipStrategy - Chiến lược đóng gói và vận chuyển
 */
public class PackAndShipStrategy implements OrderHandlingStrategy {

    @Override
    public void handle(Order order) {
        System.out.println("📦 [Chiến lược] Đóng gói và vận chuyển");
        System.out.println("  1. Chuẩn bị hàng hóa...");
        System.out.println("  2. Kiểm tra chất lượng sản phẩm...");
        System.out.println("  3. Đóng gói an toàn...");
        System.out.println("  4. Cán nhãn vận chuyển...");
        System.out.println("  5. Gửi cho bộ phận logistics...");
        System.out.println("  ✓ Đóng gói và vận chuyển thành công!\n");
    }

    @Override
    public String getStrategyName() {
        return "Đóng gói và vận chuyển";
    }
}
