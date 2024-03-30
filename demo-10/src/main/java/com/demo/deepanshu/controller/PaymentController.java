package com.demo.deepanshu.controller;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.deepanshu.dao.TransactionDAO;
import com.demo.deepanshu.model.Transaction;

@RestController
public class PaymentController {

    @Autowired
    private TransactionDAO transactionDAO; // Inject TransactionDAO

    @PostMapping("/{userId}/{orderId}/pay")
    public ResponseEntity<Map<String, Object>> makePayment(@PathVariable int userId, @PathVariable int orderId, @RequestParam double amount) {
        // Mock the payment API to randomly return any of the following status codes
        Random random = new Random();
        int statusCode = random.nextInt(6); // Generates a random number between 0 and 5

        Map<String, Object> response = new HashMap<>();
        response.put("userId", userId);
        response.put("orderId", orderId);

        // Create a new Transaction object
        Transaction transaction = new Transaction();
        transaction.setUserId(userId);
        transaction.setOrderId(orderId);

        switch (statusCode) {
            case 0:
                transaction.setStatus("successful");
                response.put("transactionId", "tran010100001");
                response.put("status", "successful");
                break;
            case 1:
                transaction.setStatus("failed");
                response.put("transactionId", "tran010100002");
                response.put("status", "failed");
                response.put("description", "Payment Failed as amount is invalid");
                break;
            case 2:
                transaction.setStatus("failed");
                response.put("transactionId", "tran010100003");
                response.put("status", "failed");
                response.put("description", "Payment Failed from bank");
                break;
            case 3:
                transaction.setStatus("failed");
                response.put("transactionId", "tran010100004");
                response.put("status", "failed");
                response.put("description", "Payment Failed due to invalid order id");
                break;
            case 4:
                transaction.setStatus("failed");
                response.put("transactionId", "tran010100005");
                response.put("status", "failed");
                response.put("description", "No response from payment server");
                break;
            case 5:
                transaction.setStatus("failed");
                response.put("transactionId", "tran010100006");
                response.put("status", "failed");
                response.put("description", "Order is already paid for");
                break;
            default:
                transaction.setStatus("failed");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "Unknown error occurred"));
        }

        // Add the transaction to the database using TransactionDAO
        transactionDAO.addTransaction(transaction);

        return ResponseEntity.ok(response);
    }
}
