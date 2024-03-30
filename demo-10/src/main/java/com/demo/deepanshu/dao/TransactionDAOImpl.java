package com.demo.deepanshu.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.deepanshu.model.Transaction;
@Repository
public class TransactionDAOImpl implements TransactionDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
//overide
    public void addTransaction(Transaction transaction) {
        String sql = "INSERT INTO Transaction (orderId, userId, status) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, transaction.getOrderId(), transaction.getUserId(), transaction.getStatus());
    }
}
