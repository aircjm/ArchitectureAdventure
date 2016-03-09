package com.aircjm.web.util;

/**
 * <字符串工具类> <br>
 *
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016/3/7 <br>
 */
public class StringUtil {
    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str != null){
            str = str.trim();
        }
        return StringUtil.isEmpty(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
