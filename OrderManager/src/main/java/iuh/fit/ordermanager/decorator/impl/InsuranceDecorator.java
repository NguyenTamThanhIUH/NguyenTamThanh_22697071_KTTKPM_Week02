package iuh.fit.ordermanager.decorator.impl;

import iuh.fit.ordermanager.decorator.OrderDecorator;
import iuh.fit.ordermanager.model.Order;

/**
 * InsuranceDecorator - Thêm dịch vụ bảo hiểm cho đơn hàng
 */
public class InsuranceDecorator extends OrderDecorator {
    private final double insuranceCost;

    public InsuranceDecorator(Order order) {
        super(order);
        this.insuranceCost = order.getTotalAmount() * 0.02; // 2% của giá trị đơn hàng
        order.addToHistory("Thêm dịch vụ: Bảo hiểm vận chuyển");
    }

    @Override
    public String getDescription() {
        return "Bảo hiểm vận chuyển (2% giá trị) - Thêm " + String.format("%.2f", insuranceCost) + " VNĐ";
    }

    public double getInsuranceCost() {
        return insuranceCost;
    }

    public void displayDetails() {
        System.out.println("🛡️ [Decorator] Bảo hiểm vận chuyển");
        System.out.println("  - Giá trị bảo hiểm: " + order.getTotalAmount() + " VNĐ");
        System.out.println("  - Tỉ lệ bảo hiểm: 2%");
        System.out.println("  - Phí bảo hiểm: " + String.format("%.2f", insuranceCost) + " VNĐ");
        System.out.println("  - Bảo hiểm bao gồm: Mất mát, hư hỏng trong quá trình vận chuyển");
        System.out.println("  - Tổng tiền: " + String.format("%.2f", order.getTotalAmount() + insuranceCost) + " VNĐ");
        System.out.println("  ✓ Bảo hiểm đã được thêm!\n");
    }
}
