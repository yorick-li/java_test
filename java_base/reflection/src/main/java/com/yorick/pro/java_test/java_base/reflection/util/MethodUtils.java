package com.yorick.pro.java_test.java_base.reflection.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    /**
     * 获取 obj 对象的、方法名为：methodName的方法的执行结果
     * @param obj 调用方法的对象
     * @param methodName 方法名称
     * @param parameterType 方法参数类型
     * @param parameters 实际调用时的方法参数
     * @param returnType 返回结果类型
     * @param <T>
     * @param <U>
     * @return
     */
    public <T, U> U getInvokeObj(T obj, String methodName, Class<?>[] parameterType, Object[] parameters, Class<U> returnType) {
        Optional<Object> optionalInvokeObj = getInvokeObj(obj, methodName, parameterType, parameters);
        if (optionalInvokeObj.isPresent()) {
            Object invokeObj = optionalInvokeObj.get();
            return returnType.cast(invokeObj);
        }
        return null;
    }

    /**
     * 获取 obj 对象的、方法名为：methodName的方法的执行结果
     * @param obj 调用方法的对象
     * @param methodName 方法名称
     * @param parameterType 方法参数类型
     * @param parameters 实际调用时的方法参数
     * @param <T>
     * @return
     */
    public <T> Optional<Object> getInvokeObj(T obj, String methodName, Class<?>[] parameterType, Object[] parameters) {
        Optional<Method> optionalMethod = getMethod(obj, methodName, parameterType);
        if (optionalMethod.isPresent()) {
            Method method = optionalMethod.get();
            method.setAccessible(Boolean.TRUE);
            try {
                Object methodInvokeResult = method.invoke(obj, parameters);
                return Optional.of(methodInvokeResult);
            } catch (IllegalAccessException e) {
                System.out.println("类：" + obj.getClass().getName() + ", 无：" + methodName + "方法的访问权限！");
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                System.out.println("类：" + obj.getClass().getName() + ", " + methodName + "方法调用异常！");
                e.printStackTrace();
            }
        }
        return Optional.ofNullable(null);
    }

}
