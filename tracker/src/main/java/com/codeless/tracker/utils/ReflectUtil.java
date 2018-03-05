package com.codeless.tracker.utils;

import java.lang.reflect.Field;

/**
 * Created by zhangdan on 2018/3/5.
 */

public class ReflectUtil {
    /**
     * 获取Object对象，指定成员变量属性值
     */
    public static Object getObjAttr(String fieldName, Object obj) {
        // 获取对象obj的所有属性域
        Field[] fields = obj.getClass().getDeclaredFields();
        Object value = null;
        for (Field field : fields) {
            // 对于每个属性，获取属性名
            String varName = field.getName();
            if (varName.equals(fieldName)) {
                try {
                    boolean access = field.isAccessible();
                    if (!access) field.setAccessible(true);
                    //从obj中获取field变量
                    value = field.get(obj);
                    if (!access) field.setAccessible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            }
        }
        return value;
    }

}