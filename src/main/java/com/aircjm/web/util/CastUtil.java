package com.aircjm.web.util;

import org.apache.commons.lang3.StringUtils;

/**
 * <Description> <br>
 *
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016/3/7 <br>
 */
public final class CastUtil {

    /**
     * Object转为String类型
     * 
     * @param obj
     * @return
     */
    public static String castString(Object obj) {
        return CastUtil.castString(obj, "");
    }

    /**
     * 转为String类型(提供默认值)
     * 
     * @param obj
     * @param defaultValue
     * @return
     */
    public static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    /**
     * 转换为double类型
     * @param obj
     * @return
     */
    public static double castDouble(Object obj) {
        return CastUtil.castDouble(obj, 0);
    }

    /**
     * 转换为double类型(提供默认值)
     * @param obj
     * @param defaultValue
     * @return
     */
    private static double castDouble(Object obj, double defaultValue) {
        double doubleValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtils.isNotEmpty(strValue)) {
                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    /**
     * 转换为long类型
     * @param obj
     * @return
     */
    public static long castLong(Object obj) {
        return CastUtil.castLong(obj, 0);
    }

    /**
     * 转换为long类型(提供默认值)
     * @param obj
     * @param defaultValue
     * @return
     */
    private static long castLong(Object obj, long defaultValue) {
        long longValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtils.isNotEmpty(strValue)) {
                try {
                    longValue = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    /**
     * 转换为int类型
     * @param obj
     * @return
     */
    public static int castInt(Object obj) {
        return CastUtil.castInt(obj, 0);
    }

    /**
     * 转换成int类型(提供默认值)
     * @param obj
     * @param defaultValue
     * @return
     */
    private static int castInt(Object obj, int defaultValue) {
        int intValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtils.isNotEmpty(strValue)) {
                try {
                    intValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }

    /**
     * 转为boolean类型
     * @param obj
     * @return
     */
    public static boolean castBoolean(Object obj){
        return CastUtil.castBoolean(obj, false);
    }


    /**
     * 转换成boolean类型(提供默认值)
     * @param obj
     * @param defaultValue
     * @return
     */
    public static boolean castBoolean(Object obj, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (obj != null) {
            String strValue = CastUtil.castString(obj);
            booleanValue = Boolean.parseBoolean(strValue);
        }
        return booleanValue;
    }
}
