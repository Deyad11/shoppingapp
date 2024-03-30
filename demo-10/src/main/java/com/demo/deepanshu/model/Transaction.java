package com.demo.deepanshu.model;

public class Transaction {
	private int transactionId;
    public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Transaction(int transactionId, int orderId, int userId, String status) {
		super();
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.userId = userId;
		this.status = status;
	}

	private int orderId;
    private int userId;
    private String status;

    public Transaction() {
    	
    }
    // Getters and setters
}
