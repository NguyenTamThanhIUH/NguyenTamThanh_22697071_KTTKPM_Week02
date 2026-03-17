package iuh.fit.ordermanager.state;

import iuh.fit.ordermanager.model.Order;

/**
 * OrderState interface - State Pattern
 * Định nghĩa các hành vi khác nhau cho mỗi trạng thái của đơn hàng
 */
public interface OrderState {
    void processOrder(Order order);
    void shipOrder(Order order);
    void deliverOrder(Order order);
    void cancelOrder(Order order);
    String getStateName();
}
