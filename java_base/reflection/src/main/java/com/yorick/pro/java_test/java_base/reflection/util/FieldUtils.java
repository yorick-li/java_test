package com.yorick.pro.java_test.java_base.reflection.util;

import com.yorick.pro.java_test.java_base.reflection.model.ObjChangeLog;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 字段反射辅助类
 */
public class FieldUtils {

    /**
     * 为某个对象，设置某个属性的属性值
     * @param obj 被设值的对象
     * @param fieldName 字段名
     * @param val 字段值
     * @param <T> obj的类型
     * @param <V> 字段的类型
     */
    public static <T, V> void setFieldVal(T obj, String fieldName, V val) {
        String methodName = "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
        Class<?> clazz = obj.getClass();
        try {
            Method method = clazz.getMethod(methodName, val.getClass());
            method.invoke(obj, val);
        } catch (NoSuchMethodException e) {
            System.out.println("类：" + clazz.getName() + ", 无：" + methodName + " 方法");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("类：" + clazz.getName() + ", 无：" + methodName + " 方法的访问权限");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("类：" + clazz.getName() + ", 方法：" + methodName + " 调用报错啦");
            e.printStackTrace();
        }
    }


    /**
     * 获取某个对象中，某个属性的值
     * @param obj 被获值的对象
     * @param fieldName 字段名
     * @param <T> obj 的类型
     * @return obj 中 fieldName 的 值
     */
    public static <T> Object getFieldValByName(T obj, String fieldName) {
        Class<?> clazz = obj.getClass();
        String getMethod = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
        Object fieldVal = null;
        try {
            Method method = clazz.getMethod(getMethod);
            fieldVal = method.invoke(obj, new Object[]{});
        } catch (NoSuchMethodException e) {
            System.out.println("类：" + clazz.getName() + ", 无：" + getMethod + " 方法");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("类：" + clazz.getName() + ", 无：" + getMethod + " 方法的访问权限");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("类：" + clazz.getName() + ", 方法：" + getMethod + " 调用报错啦");
            e.printStackTrace();
        }

        return fieldVal;
    }

    public static void main(String[] args) {
        ObjChangeLog log = new ObjChangeLog();
        log.setOldValue("1");
        log.setNewValue("1111");

        System.out.println(getFieldValByName(log, "oldValue"));
        System.out.println(getFieldValByName(log, "newValue"));

        setFieldVal(log, "oldValue", "222");
        setFieldVal(log, "newValue", "222");
        setFieldVal(log, "fieldName", "222");

        System.out.println("================================================================>");


        System.out.println(getFieldValByName(log, "oldValue"));
        System.out.println(getFieldValByName(log, "newValue"));
        System.out.println(getFieldValByName(log, "fieldName"));



    }

}
