package com.demo.deepanshu.model;
public class Order {
	  private int orderId;
	    private int userId;
	    private int quantity;
	    private double amount;
	    private String coupon;
	    private Transaction transaction;
	    public Transaction getTransaction() {
	        return transaction;
	    }

	    public void setTransaction(Transaction transaction) {
	        this.transaction = transaction;
	    }
    public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getCoupon() {
			return coupon;
		}

		public void setCoupon(String coupon) {
			this.coupon = coupon;
		}

	public Order(int orderId, int userId, int quantity, double amount, String coupon) {
			super();
			this.orderId = orderId;
			this.userId = userId;
			this.quantity = quantity;
			this.amount = amount;
			this.coupon = coupon;
		}

	public Order() {
    	
    }
   
}

