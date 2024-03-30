package com.demo.deepanshu.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/fetchCoupons")
public class CouponController {

    @GetMapping
    public ResponseEntity<Map<String, Integer>> getCoupons() {
        Map<String, Integer> coupons = new HashMap<>();
        coupons.put("OFF5", 5);
        coupons.put("OFF10", 10);
        return ResponseEntity.ok(coupons);
    }
}
