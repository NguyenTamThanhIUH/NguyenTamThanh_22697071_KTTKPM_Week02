package iuh.fit.ordermanager.strategy.impl;

import iuh.fit.ordermanager.model.Order;
import iuh.fit.ordermanager.strategy.OrderHandlingStrategy;

/**
 * UpdateStatusStrategy - Chiến lược cập nhật trạng thái đơn hàng
 */
public class UpdateStatusStrategy implements OrderHandlingStrategy {

    @Override
    public void handle(Order order) {
        System.out.println("✅ [Chiến lược] Cập nhật trạng thái đơn hàng");
        System.out.println("  - Mã đơn hàng: " + order.getOrderId());
        System.out.println("  - Trạng thái hiện tại: " + order.getCurrentState().getStateName());
        System.out.println("  - Cập nhật: Đơn hàng đã được giao thành công");
        System.out.println("  - Thời gian cập nhật: " + java.time.LocalDateTime.now());
        System.out.println("  ✓ Trạng thái đã được cập nhật!\n");
    }

    @Override
    public String getStrategyName() {
        return "Cập nhật trạng thái";
    }
}
