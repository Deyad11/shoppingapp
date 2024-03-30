package com.demo.deepanshu.dao;
import java.util.List;

import com.demo.deepanshu.model.Coupon;

public interface CouponDAO {
    List<Coupon> getAllCoupons();
    void addCoupon(Coupon coupon);

}
