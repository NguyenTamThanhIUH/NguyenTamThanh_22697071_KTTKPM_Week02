package iuh.fit.ordermanager.state.impl;

import iuh.fit.ordermanager.model.Order;
import iuh.fit.ordermanager.state.OrderState;

/**
 * ProcessingOrderState - Trạng thái khi đơn hàng đang được xử lý
 * Hành vi: Đóng gói và vận chuyển
 */
public class ProcessingOrderState implements OrderState {

    @Override
    public void processOrder(Order order) {
        System.out.println("❌ Lỗi: Đơn hàng đã ở trạng thái ĐANG XỬ LÝ!");
        System.out.println("   Không thể xử lý lại.\n");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("✓ Đóng gói đơn hàng: " + order.getOrderId());
        System.out.println("  - Chuẩn bị hàng hóa...");
        System.out.println("  - Đóng gói xong!");
        System.out.println("  - Gửi vận chuyển đến khách hàng: " + order.getCustomerName());
        order.addToHistory("Đóng gói và vận chuyển thành công");
        
        // Chuyển sang trạng thái "Đã giao"
        order.setCurrentState(new DeliveredOrderState());
        System.out.println("→ Đơn hàng chuyển sang trạng thái: ĐÃ GIAO\n");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("❌ Lỗi: Cần gửi vận chuyển trước khi cập nhật trạng thái giao!");
        System.out.println("   Vui lòng vận chuyển đơn hàng.\n");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("⚠ Hủy đơn hàng ở trạng thái ĐANG XỬ LÝ");
        System.out.println("  - Hủy quá trình xử lý...");
        System.out.println("  - Hoàn tiền: " + order.getTotalAmount() + " VNĐ");
        order.addToHistory("Hủy đơn hàng - Hoàn tiền: " + order.getTotalAmount() + " VNĐ");
        
        order.setCurrentState(new CancelledOrderState());
        System.out.println("→ Đơn hàng chuyển sang trạng thái: ĐÃ HỦY\n");
    }

    @Override
    public String getStateName() {
        return "ĐANG XỬ LÝ";
    }
}
