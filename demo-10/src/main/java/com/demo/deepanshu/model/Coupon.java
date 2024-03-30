package com.demo.deepanshu.model;
public class Coupon {
	private int couponId;
    public Coupon(int couponId, String coupon, double discountPercentage) {
		super();
		this.couponId = couponId;
		this.coupon = coupon;
		this.discountPercentage = discountPercentage;
	}
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	private String coupon;
    private double discountPercentage;
    public Coupon() {
    	
    }
}
