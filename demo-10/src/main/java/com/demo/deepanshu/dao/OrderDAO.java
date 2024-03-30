package com.demo.deepanshu.dao;

import java.util.List;

import com.demo.deepanshu.model.Order;

public interface OrderDAO {
void placeOrder(Order order);
List<Order> getUserOrders(int userId);
Order getOrderById(int orderId);
List<Order> getUserOrdersWithTransactions(int userId);

}
