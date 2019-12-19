package com.yorick.pro.java_test.java_base.reflection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ChangeLog {

    /**
     * 是否记录此字段：记录-true, 反之：false.
     * @return
     */
    boolean log() default true;

    /**
     * 字段描述
     *  例如：User类的name属性的描述为：用户名
     *  那么，description 的值应为：用户名，即：页面中字段的业务描述
     * @return
     */
    String value() default "";

    /**
     * 字段描述
     *  例如：User类的name属性的描述为：用户名
     *  那么，description 的值应为：用户名，即：页面中字段的业务描述
     * @return
     */
    String description() default "";

}
