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
        Connection connection = null;
        try {
            List<Customer> customerList = new ArrayList<Customer>();
            String sql = "select * from customer";
            // connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection = DatabaseHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setContact(resultSet.getString("contact"));
                customer.setTelephone(resultSet.getString("telephone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setRemark(resultSet.getString("remark"));
                customerList.add(customer);
            }
            return customerList;

        } catch (SQLException e) {
            LOGGER.error("execute MYSQL error ", e);
        } finally {
            DatabaseHelper.closeConnection(connection);
        }
        return null;
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
