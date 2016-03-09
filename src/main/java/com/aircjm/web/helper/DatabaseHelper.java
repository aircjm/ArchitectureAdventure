
package com.aircjm.web.helper;

import com.aircjm.web.util.PropsUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * <数据库操作助手类> <br>
 *
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016/3/9 <br>
 */
public final class DatabaseHelper {

    /**
     * 日志输出
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);

    public static final QueryRunner QUERY_RUNNER = new QueryRunner();


    private static final String DRIVER;

    private static final String URL;

    private static final String USERNAME;

    private static final String PASSWORD;

    static {
        Properties conf = PropsUtil.LoadProps("config.properties");

        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWORD = conf.getProperty("jdbc.password");

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("can not load jdbc driver", e);
        }
    }

    /**
     * 获得数据库连接
     * 
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            LOGGER.error("get Connection failure", e);
        }
        return connection;
    }

    /**
     * 关闭数据库连接
     * @param connection
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("close connection failure", e);
            }
        }
    }


    /**
     * 查询实体列表
     * @param entityClass
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params){
        List<T> entityList;
        Connection connection = getConnection();
        try{
            entityList = QUERY_RUNNER.query(connection, sql, new BeanListHandler<T>(entityClass), params);
        } catch (SQLException e){
            LOGGER.error("query list failure", e);
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
        return entityList;
    }

}