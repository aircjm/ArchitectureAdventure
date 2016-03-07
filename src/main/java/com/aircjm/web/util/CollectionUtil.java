package com.aircjm.web.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.Collection;
import java.util.Map;

/**
 * <集合工具类> <br>
 *
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016/3/7 <br>
 */
public class CollectionUtil {

    public static boolean isEmpty(Collection<?> collection){
        return CollectionUtils.isEmpty(collection);
    }

    public static boolean isNotEmpty(Collection<?> collection){
        return !isEmpty(collection);
    }


    public static boolean isEmpty(Map<?, ?> map){
        return MapUtils.isEmpty(map);
    }

    public static boolean isNotEmpty(Map<?, ?> map){
        return !isEmpty(map);
    }


}
