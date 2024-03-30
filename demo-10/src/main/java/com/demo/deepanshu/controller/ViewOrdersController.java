package com.demo.deepanshu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.deepanshu.dao.OrderDAO;
import com.demo.deepanshu.model.Order;

@RestController
@RequestMapping("/{userId}/orders")
public class ViewOrdersController {

    @Autowired
    private OrderDAO orderDAO;

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(@PathVariable int userId) {
        List<Order> orders = orderDAO.getUserOrdersWithTransactions(userId);
        return ResponseEntity.ok(orders);
    }
}
