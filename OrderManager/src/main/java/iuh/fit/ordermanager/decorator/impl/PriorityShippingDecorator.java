package iuh.fit.ordermanager.decorator.impl;

import iuh.fit.ordermanager.decorator.OrderDecorator;
import iuh.fit.ordermanager.model.Order;

/**
 * PriorityShippingDecorator - Thêm dịch vụ giao hàng nhanh ưu tiên
 */
public class PriorityShippingDecorator extends OrderDecorator {
    private final double additionalCost = 50000; // 50,000 VNĐ

    public PriorityShippingDecorator(Order order) {
        super(order);
        order.addToHistory("Thêm dịch vụ: Giao hàng ưu tiên");
    }

    @Override
    public String getDescription() {
        return "Giao hàng ưu tiên (trong 24 giờ) - Thêm " + additionalCost + " VNĐ";
    }

    public double getAdditionalCost() {
        return additionalCost;
    }

    public void displayDetails() {
        System.out.println("🚀 [Decorator] Giao hàng ưu tiên");
        System.out.println("  - Thời gian giao hàng: Trong 24 giờ");
        System.out.println("  - Phí dịch vụ: " + additionalCost + " VNĐ");
        System.out.println("  - Tổng tiền: " + (order.getTotalAmount() + additionalCost) + " VNĐ");
        System.out.println("  ✓ Dịch vụ được thêm thành công!\n");
    }
}
