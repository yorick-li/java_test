package reflection.model;

import com.yorick.pro.java_test.java_base.reflection.annotation.ChangeLog;

/**
 *
 */
public class User {

    private Long id;
    @ChangeLog(description = "用户名")
    private String name;
    @ChangeLog(description = "性别")
    private String sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
