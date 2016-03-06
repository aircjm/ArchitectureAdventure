package com.aircjm.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;


/**
 * <Description> <br> 
 *
 * @author chenjiaming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016/3/6 <br>
 */
public class ProsUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProsUtil.class);


    /**
     * 加载属性文件
     */
    public static Properties LoadProps(String filename){
        Properties props = null;
        InputStream is = null;

        try {
            is= Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
            if (is == null) {
                throw  new FileNotFoundException(filename + " file is not found");
            }
        }

    }
}
