package iuh.fit.ordermanager.state.impl;

import iuh.fit.ordermanager.model.Order;
import iuh.fit.ordermanager.state.OrderState;

/**
 * DeliveredOrderState - Trạng thái khi đơn hàng đã được giao
 * Hành vi: Cập nhật trạng thái đơn hàng là đã giao
 */
public class DeliveredOrderState implements OrderState {

    @Override
    public void processOrder(Order order) {
        System.out.println("❌ Lỗi: Không thể xử lý lại đơn hàng ở trạng thái ĐÃ GIAO!");
        System.out.println("   Đơn hàng đã hoàn tất.\n");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("❌ Lỗi: Đơn hàng đã được giao rồi!");
        System.out.println("   Không thể vận chuyển lại.\n");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("✓ Cập nhật trạng thái: Đơn hàng " + order.getOrderId() + " đã được giao");
        System.out.println("  - Khách hàng: " + order.getCustomerName() + " đã nhận hàng");
        System.out.println("  - Ngày giao: " + java.time.LocalDateTime.now());
        System.out.println("  - Tổng tiền thanh toán: " + order.getTotalAmount() + " VNĐ");
        order.addToHistory("Cập nhật trạng thái: Đã giao hàng và thanh toán xong");
        
        System.out.println("→ Đơn hàng hoàn tất!\n");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("⚠ Cảnh báo: Không thể hủy đơn hàng ở trạng thái ĐÃ GIAO!");
        System.out.println("   Vui lòng liên hệ bộ phận chăm sóc khách hàng nếu cần xử lý.\n");
    }

    @Override
    public String getStateName() {
        return "ĐÃ GIAO";
    }
}
