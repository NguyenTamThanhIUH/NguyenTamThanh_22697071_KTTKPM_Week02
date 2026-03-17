package iuh.fit.ordermanager.strategy.impl;

import iuh.fit.ordermanager.model.Order;
import iuh.fit.ordermanager.strategy.OrderHandlingStrategy;

/**
 * CancelAndRefundStrategy - Chiến lược hủy đơn hàng và hoàn tiền
 */
public class CancelAndRefundStrategy implements OrderHandlingStrategy {

    @Override
    public void handle(Order order) {
        System.out.println("💰 [Chiến lược] Hủy đơn hàng và hoàn tiền");
        System.out.println("  - Mã đơn hàng: " + order.getOrderId());
        System.out.println("  - Khách hàng: " + order.getCustomerName());
        System.out.println("  - Số tiền hoàn lại: " + order.getTotalAmount() + " VNĐ");
        System.out.println("  - Lý do: Khách hàng yêu cầu hủy");
        System.out.println("  - Trạng thái: ĐANG XỬ LÝ HOÀN TIỀN");
        System.out.println("  - Thời gian dự kiến hoàn tiền: 3-5 ngày làm việc");
        System.out.println("  ✓ Yêu cầu hủy và hoàn tiền đã được ghi nhận!\n");
    }

    @Override
    public String getStrategyName() {
        return "Hủy và hoàn tiền";
    }
}
