package iuh.fit.ordermanager.decorator.impl;

import iuh.fit.ordermanager.decorator.OrderDecorator;
import iuh.fit.ordermanager.model.Order;

/**
 * TrackingServiceDecorator - Thêm dịch vụ theo dõi đơn hàng chi tiết
 */
public class TrackingServiceDecorator extends OrderDecorator {
    private final double trackingCost = 10000; // 10,000 VNĐ

    public TrackingServiceDecorator(Order order) {
        super(order);
        order.addToHistory("Thêm dịch vụ: Theo dõi chi tiết");
    }

    @Override
    public String getDescription() {
        return "Dịch vụ theo dõi chi tiết - Thêm " + trackingCost + " VNĐ";
    }

    public double getTrackingCost() {
        return trackingCost;
    }

    public void displayDetails() {
        System.out.println("📍 [Decorator] Dịch vụ theo dõi chi tiết");
        System.out.println("  - Theo dõi vị trí: Thời gian thực (GPS)");
        System.out.println("  - Thông báo: SMS + Email + App");
        System.out.println("  - Cập nhật: Mỗi 4 giờ hoặc khi có thay đổi");
        System.out.println("  - Phí dịch vụ: " + trackingCost + " VNĐ");
        System.out.println("  - Tổng tiền: " + (order.getTotalAmount() + trackingCost) + " VNĐ");
        System.out.println("  ✓ Dịch vụ theo dõi đã được thêm!\n");
    }
}
