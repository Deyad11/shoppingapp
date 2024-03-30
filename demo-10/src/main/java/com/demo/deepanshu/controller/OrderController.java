package com.demo.deepanshu.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.demo.deepanshu.dao.OrderDAO;
import com.demo.deepanshu.model.Order;

@RestController
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    // Import necessary classes

    private static Set<String> usedCoupons = new HashSet<>();

    // Other methods and mappings

    @PostMapping("/{userId}/order")
    public ResponseEntity<Map<String, Object>> placeOrder(@PathVariable int userId, @RequestParam int qty, @RequestParam String coupon) {
        // Validate quantity and coupon
        if (qty < 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("description", "Invalid quantity"));
        }
        if (!isValidCoupon(coupon)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("description", "Invalid coupon"));
        }
        if (usedCoupons.contains(coupon)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("description", "Coupon already used"));
        }

        // Calculate amount
        double amount = calculateOrderAmount(qty, coupon); // Implement this method based on your business logic

        Order order = new Order();
        order.setUserId(userId);
        order.setQuantity(qty);
        order.setAmount(amount);
        order.setCoupon(coupon);

        orderDAO.placeOrder(order);

        // Update inventory
        InventoryController.updateInventory(qty);

        // Mark coupon as used
        usedCoupons.add(coupon);

        Map<String, Object> response = new HashMap<>();
        response.put("orderId", order.getOrderId());
        response.put("userId", userId);
        response.put("quantity", qty);
        response.put("amount", amount);
        response.put("coupon", coupon);
        return ResponseEntity.ok(response);
    }

    // Method to calculate order amount
    private double calculateOrderAmount(int qty, String coupon) {
        // Assuming a fixed price per item
        double pricePerItem = 100; // Replace with your actual price per item

        // Get the discount percentage based on the coupon
        double discountPercentage = getCouponDiscountPercentage(coupon); // Implement this method to retrieve discount percentage

        // Calculate the total price before discount
        double totalPriceBeforeDiscount = pricePerItem * qty;

        // Apply the discount
        double discountedAmount = totalPriceBeforeDiscount * (1 - discountPercentage / 100);

        return discountedAmount;
    }

    // Method to retrieve discount percentage based on coupon
    private double getCouponDiscountPercentage(String coupon) {
        // Implement logic to retrieve discount percentage based on the provided coupon
        // For simplicity, assuming fixed discount percentages for given coupons
        if ("OFF5".equals(coupon)) {
            return 5.0;
        } else if ("OFF10".equals(coupon)) {
            return 10.0;
        } else {
            // Default discount if coupon not found
            return 0.0;
        }
    }

    // Method to validate coupon
    private boolean isValidCoupon(String coupon) {
        // Implement logic to validate the coupon
        // For simplicity, assume valid coupons are "OFF5" and "OFF10"
        return "OFF5".equals(coupon) || "OFF10".equals(coupon);
    }
}
