package iuh.fit.ordermanager.strategy;

import iuh.fit.ordermanager.model.Order;

/**
 * OrderHandlingStrategy interface - Strategy Pattern
 * Định nghĩa các chiến lược xử lý khác nhau cho đơn hàng
 */
public interface OrderHandlingStrategy {
    void handle(Order order);
    String getStrategyName();
}
