package iuh.fit.ordermanager.strategy.impl;

import iuh.fit.ordermanager.model.Order;
import iuh.fit.ordermanager.strategy.OrderHandlingStrategy;

/**
 * CheckOrderInfoStrategy - Chiến lược kiểm tra thông tin đơn hàng
 */
public class CheckOrderInfoStrategy implements OrderHandlingStrategy {

    @Override
    public void handle(Order order) {
        System.out.println("📋 [Chiến lược] Kiểm tra thông tin đơn hàng");
        System.out.println("  - Mã đơn hàng: " + order.getOrderId());
        System.out.println("  - Khách hàng: " + order.getCustomerName());
        System.out.println("  - Tổng tiền: " + order.getTotalAmount() + " VNĐ");
        System.out.println("  - Ngày tạo: " + order.getCreatedDate());
        System.out.println("  ✓ Thông tin hợp lệ!\n");
    }

    @Override
    public String getStrategyName() {
        return "Kiểm tra thông tin";
    }
}
