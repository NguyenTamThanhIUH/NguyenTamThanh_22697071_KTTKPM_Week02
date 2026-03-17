package iuh.fit.ordermanager.decorator.impl;

import iuh.fit.ordermanager.decorator.OrderDecorator;
import iuh.fit.ordermanager.model.Order;

/**
 * GiftWrappingDecorator - Thêm dịch vụ bao gói quà tặng
 */
public class GiftWrappingDecorator extends OrderDecorator {
    private final double giftCost = 35000; // 35,000 VNĐ
    private String giftMessage;

    public GiftWrappingDecorator(Order order) {
        super(order);
        order.addToHistory("Thêm dịch vụ: Bao gói quà tặng");
    }

    public GiftWrappingDecorator(Order order, String giftMessage) {
        this(order);
        this.giftMessage = giftMessage;
        order.addToHistory("Thêm lời nhắn quà: " + giftMessage);
    }

    @Override
    public String getDescription() {
        if (giftMessage != null) {
            return "Bao gói quà tặng (kèm lời nhắn) - Thêm " + giftCost + " VNĐ";
        }
        return "Bao gói quà tặng - Thêm " + giftCost + " VNĐ";
    }

    public double getGiftCost() {
        return giftCost;
    }

    public String getGiftMessage() {
        return giftMessage;
    }

    public void displayDetails() {
        System.out.println("🎁 [Decorator] Bao gói quà tặng");
        System.out.println("  - Loại bao gói: Bao gói đặc biệt cao cấp");
        System.out.println("  - Phí bao gói: " + giftCost + " VNĐ");
        if (giftMessage != null) {
            System.out.println("  - Lời nhắn: \"" + giftMessage + "\"");
        }
        System.out.println("  - Tổng tiền: " + (order.getTotalAmount() + giftCost) + " VNĐ");
        System.out.println("  ✓ Bao gói quà tặng đã được thêm!\n");
    }
}
