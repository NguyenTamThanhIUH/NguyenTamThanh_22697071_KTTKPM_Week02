package iuh.fit.ordermanager.demo;

import iuh.fit.ordermanager.model.Order;
import iuh.fit.ordermanager.strategy.impl.CheckOrderInfoStrategy;
import iuh.fit.ordermanager.strategy.impl.PackAndShipStrategy;
import iuh.fit.ordermanager.strategy.impl.UpdateStatusStrategy;
import iuh.fit.ordermanager.strategy.impl.CancelAndRefundStrategy;
import iuh.fit.ordermanager.decorator.impl.PriorityShippingDecorator;
import iuh.fit.ordermanager.decorator.impl.InsuranceDecorator;
import iuh.fit.ordermanager.decorator.impl.GiftWrappingDecorator;
import iuh.fit.ordermanager.decorator.impl.TrackingServiceDecorator;

/**
 * OrderManagementDemo - Hiển thị cách sử dụng State, Strategy, và Decorator patterns
 */
public class OrderManagementDemo {

    public static void main(String[] args) {
        System.out.println("=" . repeat(80));
        System.out.println("HỆ THỐNG QUẢN LÝ ĐƠN HÀNG - DEMO CÁC DESIGN PATTERN");
        System.out.println("=" . repeat(80));
        System.out.println();

        // ============================================================================
        // DEMO 1: STATE PATTERN - Quản lý trạng thái đơn hàng
        // ============================================================================
        System.out.println("\n" + "█".repeat(80));
        System.out.println("DEMO 1: STATE PATTERN - Quản lý chu kỳ đơn hàng");
        System.out.println("█".repeat(80) + "\n");

        Order order1 = new Order("ORD001", "Nguyễn Tam Thành", 1500000);
        System.out.println("✓ Tạo đơn hàng mới: " + order1 + "\n");

        System.out.println("--- Bước 1: Xử lý đơn hàng (từ trạng thái MỚI TẠO) ---");
        order1.processOrder();

        System.out.println("--- Bước 2: Vận chuyển đơn hàng (từ trạng thái ĐANG XỬ LÝ) ---");
        order1.shipOrder();

        System.out.println("--- Bước 3: Giao đơn hàng (từ trạng thái ĐÃ GIAO) ---");
        order1.deliverOrder();

        System.out.println("\n📊 Lịch sử hoạt động của đơn hàng:");
        for (String action : order1.getActionHistory()) {
            System.out.println("  • " + action);
        }

        // ============================================================================
        // DEMO 2: STRATEGY PATTERN - Các chiến lược xử lý khác nhau
        // ============================================================================
        System.out.println("\n\n" + "█".repeat(80));
        System.out.println("DEMO 2: STRATEGY PATTERN - Áp dụng chiến lược xử lý");
        System.out.println("█".repeat(80) + "\n");

        Order order2 = new Order("ORD002", "Trần Long Vũ", 2000000);
        System.out.println("✓ Tạo đơn hàng: " + order2 + "\n");

        // Chiến lược 1: Kiểm tra thông tin
        System.out.println("--- Chiến lược 1: Kiểm tra thông tin ---");
        order2.setStrategy(new CheckOrderInfoStrategy());
        order2.handleWithStrategy();

        // Chiến lược 2: Đóng gói và vận chuyển
        System.out.println("--- Chiến lược 2: Đóng gói và vận chuyển ---");
        order2.setStrategy(new PackAndShipStrategy());
        order2.handleWithStrategy();

        // Chiến lược 3: Cập nhật trạng thái
        System.out.println("--- Chiến lược 3: Cập nhật trạng thái ---");
        order2.setStrategy(new UpdateStatusStrategy());
        order2.handleWithStrategy();

        // ============================================================================
        // DEMO 3: HỶY ĐƠN HÀNG - Hủy và hoàn tiền
        // ============================================================================
        System.out.println("\n" + "█".repeat(80));
        System.out.println("DEMO 3: HỦY ĐƠN HÀNG - Sử dụng Strategy hủy và hoàn tiền");
        System.out.println("█".repeat(80) + "\n");

        Order order3 = new Order("ORD003", "Lê Văn A", 800000);
        System.out.println("✓ Tạo đơn hàng: " + order3 + "\n");

        System.out.println("--- Xử lý đơn hàng ---");
        order3.processOrder();

        System.out.println("--- Khách hàng yêu cầu hủy - Sử dụng Strategy hủy ---");
        order3.setStrategy(new CancelAndRefundStrategy());
        order3.handleWithStrategy();

        System.out.println("--- Thực hiện hủy ---");
        order3.cancelOrder();

        // ============================================================================
        // DEMO 4: DECORATOR PATTERN - Thêm các dịch vụ bổ sung
        // ============================================================================
        System.out.println("\n" + "█".repeat(80));
        System.out.println("DEMO 4: DECORATOR PATTERN - Thêm dịch vụ bổ sung cho đơn hàng");
        System.out.println("█".repeat(80) + "\n");

        Order order4 = new Order("ORD004", "Phạm Minh B", 3000000);
        System.out.println("✓ Tạo đơn hàng cơ bản: " + order4 + "\n");

        // Thêm dịch vụ 1: Giao hàng ưu tiên
        System.out.println("--- Thêm Decorator 1: Giao hàng ưu tiên ---");
        PriorityShippingDecorator priorityOrder = new PriorityShippingDecorator(order4);
        priorityOrder.displayDetails();

        // Thêm dịch vụ 2: Bảo hiểm
        System.out.println("--- Thêm Decorator 2: Bảo hiểm vận chuyển ---");
        InsuranceDecorator insuranceOrder = new InsuranceDecorator(order4);
        insuranceOrder.displayDetails();

        // Thêm dịch vụ 3: Bao gói quà tặng
        System.out.println("--- Thêm Decorator 3: Bao gói quà tặng ---");
        GiftWrappingDecorator giftOrder = new GiftWrappingDecorator(
            order4,
                "Chúc mừng sinh nhật! Yêu bạn! 🎉"
        );
        giftOrder.displayDetails();

        // Thêm dịch vụ 4: Theo dõi chi tiết
        System.out.println("--- Thêm Decorator 4: Dịch vụ theo dõi chi tiết ---");
        TrackingServiceDecorator trackingOrder = new TrackingServiceDecorator(order4);
        trackingOrder.displayDetails();

        System.out.println("📊 Lịch sử đơn hàng với các dịch vụ thêm:");
        for (String action : order4.getActionHistory()) {
            System.out.println("  • " + action);
        }

        double totalCost = order4.getTotalAmount() 
            + priorityOrder.getAdditionalCost() 
            + insuranceOrder.getInsuranceCost() 
            + giftOrder.getGiftCost() 
            + trackingOrder.getTrackingCost();
        System.out.println("\n💰 TỔNG GIÁ TRỊ ĐƠN HÀNG (bao gồm tất cả dịch vụ): " + String.format("%.2f", totalCost) + " VNĐ\n");

        // ============================================================================
        // DEMO 5: KẾT HỢP CẢ BA PATTERN
        // ============================================================================
        System.out.println("\n" + "█".repeat(80));
        System.out.println("DEMO 5: KẾT HỢP CẢ BA DESIGN PATTERN");
        System.out.println("█".repeat(80) + "\n");

        Order order5 = new Order("ORD005", "Hoàng Thị C", 2500000);
        System.out.println("✓ Tạo đơn hàng: " + order5 + "\n");

        // Sử dụng State Pattern: Xử lý đơn hàng
        System.out.println("➊ STATE: Kiểm tra thông tin và xử lý đơn hàng");
        order5.processOrder();

        // Thêm dịch vụ bổ sung bằng Decorator Pattern
        System.out.println("➋ DECORATOR: Thêm giao hàng ưu tiên");
        PriorityShippingDecorator order5Priority = new PriorityShippingDecorator(order5);
        order5Priority.displayDetails();

        // Sử dụng Strategy Pattern: Xử lý vận chuyển
        System.out.println("➌ STRATEGY: Thực hiện đóng gói và vận chuyển");
        order5.setStrategy(new PackAndShipStrategy());
        order5.handleWithStrategy();

        System.out.println("➍ STATE & STRATEGY: Vận chuyển và cập nhật trạng thái");
        order5.shipOrder();
        order5.setStrategy(new UpdateStatusStrategy());
        order5.handleWithStrategy();

        System.out.println("➎ STATE: Giao đơn hàng");
        order5.deliverOrder();

        System.out.println("\n📋 TÓÁM TẮT LUỒNG XỬ LÝ HOÀN CHỈNH:");
        for (String action : order5.getActionHistory()) {
            System.out.println("  ✓ " + action);
        }

        double totalOrder5 = order5.getTotalAmount() + order5Priority.getAdditionalCost();
        System.out.println("\n💰 Tổng giá trị đơn hàng: " + String.format("%.2f", totalOrder5) + " VNĐ");

        System.out.println("\n" + "=".repeat(80));
        System.out.println("HOÀN TẤT DEMO CÁC DESIGN PATTERN");
        System.out.println("=" . repeat(80));
    }
}
