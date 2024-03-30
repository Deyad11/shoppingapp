package com.demo.deepanshu.controller;

import com.demo.deepanshu.dao.CouponDAO;
import com.demo.deepanshu.dao.UserDAO;
import com.demo.deepanshu.model.Coupon;
import com.demo.deepanshu.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CouponDAO couponDAO;
//endpoint to add a new user
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        userDAO.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
    }
//endpoint to add a new coupon
    @PostMapping("/coupons/add")
    public ResponseEntity<?> addCoupon(@RequestBody Coupon coupon) {
        couponDAO.addCoupon(coupon);
        return ResponseEntity.status(HttpStatus.CREATED).body("Coupon added successfully");
    }
}
