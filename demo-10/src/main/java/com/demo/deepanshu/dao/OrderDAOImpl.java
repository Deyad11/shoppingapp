package com.demo.deepanshu.dao;

import com.demo.deepanshu.model.Order;
import com.demo.deepanshu.model.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Order> getUserOrdersWithTransactions(int userId) {
        String sql = "SELECT o.*, t.transactionId, t.status FROM Orders o LEFT JOIN Transaction t ON o.orderId = t.orderId WHERE o.userId = ?";
        return jdbcTemplate.query(sql, new Object[] { userId }, new OrderWithTransactionMapper());
    }
    private static final class OrderWithTransactionMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setOrderId(rs.getInt("orderId"));
            order.setUserId(rs.getInt("userId"));
            // Set other order properties
            Transaction transaction = new Transaction();
            // Assuming transactionId is an int in the database
            transaction.setTransactionId(rs.getInt("transactionId"));
            transaction.setStatus(rs.getString("status"));
            // Set other transaction properties
            order.setTransaction(transaction);
            return order;
        }
    }

    @Override
    public void placeOrder(Order order) {
        String sql = "INSERT INTO Orders (userId, quantity, amount, coupon) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getUserId(), order.getQuantity(), order.getAmount(), order.getCoupon());
    }

    @Override
    public List<Order> getUserOrders(int userId) {
        String sql = "SELECT * FROM Orders WHERE userId = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new OrderMapper());
    }

    @Override
    public Order getOrderById(int orderId) {
        String sql = "SELECT * FROM Orders WHERE orderId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{orderId}, new OrderMapper());
    }

    private static final class OrderMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setOrderId(rs.getInt("orderId"));
            order.setUserId(rs.getInt("userId"));
            order.setQuantity(rs.getInt("quantity"));
            order.setAmount(rs.getDouble("amount"));
            order.setCoupon(rs.getString("coupon"));
            return order;
        }
    }
}
