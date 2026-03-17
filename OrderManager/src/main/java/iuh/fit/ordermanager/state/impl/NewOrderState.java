package iuh.fit.ordermanager.state.impl;

import iuh.fit.ordermanager.model.Order;
import iuh.fit.ordermanager.state.OrderState;

/**
 * NewOrderState - Trạng thái khi đơn hàng mới được tạo
 * Hành vi: Kiểm tra thông tin đơn hàng
 */
public class NewOrderState implements OrderState {

    @Override
    public void processOrder(Order order) {
        System.out.println("✓ Kiểm tra thông tin đơn hàng: " + order.getOrderId());
        System.out.println("  - Khách hàng: " + order.getCustomerName());
        System.out.println("  - Tổng tiền: " + order.getTotalAmount() + " VNĐ");
        System.out.println("  - Thông tin hợp lệ!");
        order.addToHistory("Kiểm tra thông tin đơn hàng - OK");
        
        // Chuyển sang trạng thái "Đang xử lý"
        order.setCurrentState(new ProcessingOrderState());
        System.out.println("→ Đơn hàng chuyển sang trạng thái: ĐANG XỬ LÝ\n");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("❌ Lỗi: Không thể vận chuyển đơn hàng ở trạng thái MỚI TẠO!");
        System.out.println("   Vui lòng xử lý đơn hàng trước.\n");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("❌ Lỗi: Không thể giao đơn hàng ở trạng thái MỚI TẠO!");
        System.out.println("   Vui lòng xử lý và vận chuyển đơn hàng trước.\n");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("✓ Hủy đơn hàng ở trạng thái MỚI TẠO");
        System.out.println("  - Hoàn tiền: " + order.getTotalAmount() + " VNĐ");
        order.addToHistory("Hoàn tiền: " + order.getTotalAmount() + " VNĐ");
        
        order.setCurrentState(new CancelledOrderState());
        System.out.println("→ Đơn hàng chuyển sang trạng thái: ĐÃ HỦY\n");
    }

    @Override
    public String getStateName() {
        return "MỚI TẠO";
    }
}
