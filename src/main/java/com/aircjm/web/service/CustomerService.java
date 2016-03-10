package com.aircjm.web.service;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.aircjm.web.helper.DatabaseHelper;
import com.aircjm.web.model.Customer;
import com.aircjm.web.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <提供客户数据服务> <br>
 *
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016/3/6 <br>
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    public List<Customer> getCustomerList() {
        String sql = "select * from customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    public List<Customer> getCustomerList(String keyword) {
        return null;
    }

    public Customer getCustomer(long id) {
        return null;
    }

    public boolean createCustomer(Map<String, Object> fieldMap) {
        return false;
    }

    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return false;
    }

    public boolean deleteCustomer(long id) {
        return false;
    }

}
