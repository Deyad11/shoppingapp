package com.demo.deepanshu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.deepanshu.model.Coupon;

@Repository
public class CouponDAOImpl implements CouponDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addCoupon(Coupon coupon) {
        String sql = "INSERT INTO Coupon (coupon, discountPercentage) VALUES (?, ?)";
        jdbcTemplate.update(sql, coupon.getCoupon(), coupon.getDiscountPercentage());
    }
    @Override
    public List<Coupon> getAllCoupons() {
        String sql = "SELECT * FROM Coupon";
        return jdbcTemplate.query(sql, new CouponMapper());
    }
    
    private static final class CouponMapper implements RowMapper<Coupon> {
        @Override
        public Coupon mapRow(ResultSet rs, int rowNum) throws SQLException {
            Coupon coupon = new Coupon();
            coupon.setCouponId(rs.getInt("couponId"));
            coupon.setCoupon(rs.getString("coupon"));
            coupon.setDiscountPercentage(rs.getDouble("discountPercentage"));
            return coupon;
        }
    }
}
