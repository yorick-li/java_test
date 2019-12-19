package com.yorick.pro.java_test.java_base.reflection.util;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Optional;

/**
 * 方法反射辅助类
 */
public class MethodUtils {

    /**
     * 获取某个obj的 名为：methodName 的方法
     * @param obj 某个类型的对象
     * @param methodName 方法名
     * @param parameterType 方法参数类型
     * @param <T>
     * @return
     */
    public <T> Optional<Method> getMethod(T obj, String methodName, Class<?>... parameterType) {
        Class<?> clazz = obj.getClass();
        Method method = null;
        try {
            method = clazz.getMethod(methodName, parameterType);
        } catch (NoSuchMethodException e) {
            System.out.println("类：" + clazz.getName() + ", 无：" + methodName + "方法！");
            e.printStackTrace();
        }
        return Optional.of(method);
    }

    /**
     * 获取方法的返回值类型
     * @param obj 某个类型的对象
     * @param methodName 方法名
     * @param parameterType 方法的参数类型列表
     */
    public <T, U> Optional<Class<?>> getMethodReturnType(T obj, String methodName, Class<?>... parameterType) {
        Optional<Method> optionalMethod = getMethod(obj, methodName, parameterType);
        if (optionalMethod.isPresent()) {
            Method method = optionalMethod.get();
            Class<?> returnType = method.getReturnType();
            return Optional.of(returnType);
        }
        return Optional.ofNullable(null);
    }

}
