package com.demo.deepanshu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private static int availableProducts = 100; // Initial available products
    private static int orderedProducts = 0; // Initial ordered products

    @GetMapping
    public ResponseEntity<Map<String, Object>> getInventory() {
        Map<String, Object> inventory = new HashMap<>();
        inventory.put("ordered", orderedProducts);
        inventory.put("price", 100); // Assuming a fixed price per product
        inventory.put("available", availableProducts);
        return ResponseEntity.ok(inventory);
    }

    // Method to update available and ordered products after placing an order
    public static synchronized void updateInventory(int orderedQuantity) {
        orderedProducts += orderedQuantity;
        availableProducts -= orderedQuantity;
    }
}
