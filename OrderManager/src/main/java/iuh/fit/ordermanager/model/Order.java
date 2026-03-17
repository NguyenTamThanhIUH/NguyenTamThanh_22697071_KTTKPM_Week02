package iuh.fit.ordermanager.model;

import iuh.fit.ordermanager.state.OrderState;
import iuh.fit.ordermanager.state.impl.NewOrderState;
import iuh.fit.ordermanager.strategy.OrderHandlingStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Order class - Đại diện cho một đơn hàng trong hệ thống
 * Sử dụng State Pattern để quản lý trạng thái của đơn hàng
 */
public class Order {
    private String orderId;
    private String customerName;
    private double totalAmount;
    private LocalDateTime createdDate;
    private OrderState currentState;
    private OrderHandlingStrategy strategy;
    private List<String> actionHistory;

    public Order(String orderId, String customerName, double totalAmount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.createdDate = LocalDateTime.now();
        this.currentState = new NewOrderState();
        this.actionHistory = new ArrayList<>();
        this.actionHistory.add("Đơn hàng được tạo mới lúc " + createdDate);
    }

    // State Pattern methods
    public void processOrder() {
        currentState.processOrder(this);
        actionHistory.add("Trạng thái: " + currentState.getStateName());
    }

    public void shipOrder() {
        currentState.shipOrder(this);
        actionHistory.add("Trạng thái: " + currentState.getStateName());
    }

    public void deliverOrder() {
        currentState.deliverOrder(this);
        actionHistory.add("Trạng thái: " + currentState.getStateName());
    }

    public void cancelOrder() {
        currentState.cancelOrder(this);
        actionHistory.add("Trạng thái: " + currentState.getStateName());
    }

    // Strategy Pattern methods
    public void setStrategy(OrderHandlingStrategy strategy) {
        this.strategy = strategy;
    }

    public void handleWithStrategy() {
        if (strategy != null) {
            strategy.handle(this);
            actionHistory.add("Chiến lược xử lý: " + strategy.getStrategyName());
        }
    }

    // Getters and setters
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public OrderState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(OrderState state) {
        this.currentState = state;
    }

    public List<String> getActionHistory() {
        return actionHistory;
    }

    public void addToHistory(String action) {
        actionHistory.add(action);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", totalAmount=" + totalAmount +
                ", status='" + currentState.getStateName() + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
