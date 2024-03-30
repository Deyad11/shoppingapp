package com.demo.deepanshu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.deepanshu.dao.OrderDAO;
import com.demo.deepanshu.model.Order;

import java.util.List;

@RestController
@RequestMapping("/{userId}/orders/{orderId}")
public class ViewOrderDetailsController {

    @Autowired
    private OrderDAO orderDAO;

    @GetMapping
    public ResponseEntity<List<Order>> getOrderDetails(@PathVariable int userId, @PathVariable int orderId) {
        List<Order> orders = orderDAO.getUserOrdersWithTransactions(userId);
        return ResponseEntity.ok(orders);
    }
}
