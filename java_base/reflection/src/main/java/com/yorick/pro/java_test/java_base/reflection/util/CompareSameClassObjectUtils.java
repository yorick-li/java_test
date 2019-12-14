package com.yorick.pro.java_test.java_base.reflection.util;

import com.yorick.pro.java_test.java_base.reflection.model.ObjChangeLog;
import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 比较同类的不同两个对象
 *
 * @author yorick
 */
public class CompareSameClassObjectUtils {

    /**
     * 比较 旧对象、新对象 之间 字段值有差异的字段，
     * 并将其保存为 ObjChangeLog 实体的列表
     * @param oldObj 旧对象
     * @param newObj 新对象
     * @param <T> T 中的字段：基础类 [String、Date、8种基本类型及其包装类];
     *            T 一般是: 与数据库中的表 对应的实体
     * @return 字段值有差异的 ObjChangeLog 列表
     */
    public static <T> List<ObjChangeLog> compare(T oldObj, T newObj) {
        // 1. 获取 T类 的所有字段
        Class<?> clazz = oldObj.getClass();
        Field[] clazzFields = clazz.getDeclaredFields();
        if (clazzFields == null || clazzFields.length == 0) {
            return Collections.emptyList();
        }
        // 将所有字段的数组 转为 List, 方便遍历
        List<Field> fields = Arrays.asList(clazzFields);
        // 用于存放改变的字段
        List<ObjChangeLog> changeLogs = compare(oldObj, newObj, fields, false);
        return changeLogs;
    }


    /**
     * 比较 旧对象、新对象 之间 指定字段的字段值是否有差异；
     * 有差异的，并将其保存为 ObjChangeLog 实体的列表
     * @param oldObj 旧对象
     * @param newObj 新对象
     * @param <T> T 中的字段：基础类 [String、Date、8种基本类型及其包装类];
     *            T 一般是: 与数据库中的表 对应的实体
     * @return 字段值有差异的 ObjChangeLog 列表
     */
    public static <T> List<ObjChangeLog> compare(T oldObj, T newObj, final List<Field> fields, boolean flag) {
        // 用于存放改变的字段
        List<ObjChangeLog> changeLogs = new ArrayList<>(fields.size());
        fields.forEach(field -> {
            try {
                field.setAccessible(Boolean.TRUE);
                Object oldValue = field.get(oldObj);
                Object newValue = field.get(newObj);
                // 2. 比对 oldObj 与 newObj 的值===>若不相同,则创建 ObjChangeLog 实体,为其设置值,加到List中,并返回
                // 旧值与新值是否相同的标志位:true->相同;false->不同
                boolean equal = (Objects.isNull(oldValue) && Objects.isNull(newValue))
                        || (!Objects.isNull(oldObj) && !Objects.isNull(newValue) && oldObj.equals(newValue));
                if (!equal) {
                    ObjChangeLog changeLog = new ObjChangeLog();
                    changeLog.setFieldName(field.getName());
                    changeLog.setOldValue(Objects.isNull(oldValue) ? null : oldValue.toString());
                    changeLog.setNewValue(Objects.isNull(newValue) ? null : newValue.toString());
                    changeLogs.add(changeLog);
                }
            } catch (IllegalAccessException e) {
                System.out.println(oldObj.getClass().getName()+" 的对象："+ oldObj.toString() + "，" + field.getName() + " 字段无权限访问！");
                e.printStackTrace();
            }
        });

        return changeLogs;
    }

    /**
     * 比较 旧对象、新对象 之间 指定字段的字段值是否有差异；
     * 有差异的，并将其保存为 ObjChangeLog 实体的列表
     * @param oldObj 旧对象
     * @param newObj 新对象
     * @param <T> T 中的字段：基础类 [String、Date、8种基本类型及其包装类];
     *            T 一般是: 与数据库中的表 对应的实体
     * @return 字段值有差异的 ObjChangeLog 列表
     */
    public static <T> List<ObjChangeLog> compare(T oldObj, T newObj, final List<String> fieldNames) {
        Class<?> aClass = oldObj.getClass();
        List<Field> fields = getFieldsByFieldNames(aClass, fieldNames);
        List<ObjChangeLog> objChangeLogs = compare(oldObj, newObj, fields, false);
        return objChangeLogs;
    }

    /**
     * 获取 clazz 类的，与 fieldName 的值匹配的字段属性
     * @param clazz
     * @param fieldNames
     * @return
     */
    private static List<Field> getFieldsByFieldNames(Class<?> clazz, List<String> fieldNames) {
        if (CollectionUtils.isEmpty(fieldNames)) {
            return null;
        }
        if (Objects.isNull(clazz)) {
            return null;
        }

        // 获取字段属性列表
        List<Field> fields = new ArrayList<>(fieldNames.size());
        // 类中所有的字段
        Field[] clazzFields = clazz.getFields();
        for (String fieldName : fieldNames) {
            for (Field field : clazzFields) {
                if (field.getName().equals(fieldName)) {
                    fields.add(field);
                }
            }
        }

        return fields;
    }





    public static void main(String[] args) {

        ObjChangeLog log = new ObjChangeLog();
        log.setOldValue("1");
        log.setNewValue("1");

        List<ObjChangeLog> test = new ArrayList<>();
        test.add(log);

        log.setOldValue("2");
        log.setNewValue("2");

        test.add(log);

        System.out.println(log);

    }


}
