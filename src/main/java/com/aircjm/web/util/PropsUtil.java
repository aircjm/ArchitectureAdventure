package com.aircjm.web.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <Description> <br>
 *
 * @author chenjiaming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016/3/6 <br>
 */
public class PropsUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     */
    public static Properties LoadProps(String filename) {
        Properties props = null;
        InputStream is = null;

        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
            if (is == null) {
                throw new FileNotFoundException(filename + " file is not found");
            }
            props = new Properties();

            props.load(is);
        } catch (IOException e) {
            LOGGER.error("load properties file failure", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("close input stream failure", e);
                }
            }
        }
        return props;
    }

    /**
     * 获取字符型属性(默认值为空字符串)
     * @param props
     * @param key
     * @return
     */
    public static String getString(Properties props, String key){
        return  getString(props, key, "");
    }


    /**
     * 获取字符型属性(可指定默认值)
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    private static String getString(Properties props, String key, String defaultValue) {
        String value = defaultValue;
        if (props.containsKey(key)){
            value = props.getProperty(key);
        }
        return value;
    }


    /**
     * 获取数值型属性(默认值为0)
     * @param props
     * @param key
     * @return
     */
    public static int getInt(Properties props, String key){
        return getInt(props, key, 0);
    }


    /**
     * 获取数值型属性(指定默认值)
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(Properties props, String key, int defaultValue){
        int value = defaultValue;
        if (props.containsKey(key)){
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }


    public static boolean getBoolean(Properties props, String key){
        return getBoolean(props, key, false);
    }

    private static boolean getBoolean(Properties props, String key, Boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (props.containsKey(key)){
            booleanValue = CastUtil.castBoolean(props.getProperty(key));
        }
        return booleanValue;
    }
}
