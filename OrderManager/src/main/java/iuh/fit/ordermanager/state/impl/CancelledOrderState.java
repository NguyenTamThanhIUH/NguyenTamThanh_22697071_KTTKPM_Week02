package iuh.fit.ordermanager.state.impl;

import iuh.fit.ordermanager.model.Order;
import iuh.fit.ordermanager.state.OrderState;

/**
 * CancelledOrderState - Trạng thái khi đơn hàng đã bị hủy
 * Hành vi: Hủy đơn hàng và hoàn tiền
 */
public class CancelledOrderState implements OrderState {

    @Override
    public void processOrder(Order order) {
        System.out.println("❌ Lỗi: Không thể xử lý đơn hàng ở trạng thái ĐÃ HỦY!");
        System.out.println("   Đơn hàng đã bị hủy.\n");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("❌ Lỗi: Không thể vận chuyển đơn hàng ở trạng thái ĐÃ HỦY!");
        System.out.println("   Đơn hàng đã bị hủy.\n");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("❌ Lỗi: Không thể giao đơn hàng ở trạng thái ĐÃ HỦY!");
        System.out.println("   Đơn hàng đã bị hủy.\n");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("⚠ Thông báo: Đơn hàng " + order.getOrderId() + " đã bị hủy rồi!");
        System.out.println("   Không thể hủy lại.\n");
    }

    @Override
    public String getStateName() {
        return "ĐÃ HỦY";
    }
}
