package iuh.fit.ordermanager.decorator;

import iuh.fit.ordermanager.model.Order;

/**
 * OrderDecorator - Abstract base class for Order decorators (Decorator Pattern)
 * Cho phép thêm các tính năng mới cho đơn hàng một cách động
 */
public abstract class OrderDecorator {
    protected Order order;

    public OrderDecorator(Order order) {
        this.order = order;
    }

    public abstract String getDescription();

    public Order getOrder() {
        return order;
    }
}
