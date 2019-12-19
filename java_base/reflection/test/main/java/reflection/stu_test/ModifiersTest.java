package reflection.stu_test;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class ModifiersTest {

    private String name;
    String sex;
    protected String height;
    public String weight;

    @Test
    public void testField() {
        Class<ModifiersTest> modifiersTestClass = ModifiersTest.class;
        Field[] fields = modifiersTestClass.getDeclaredFields();
        List<Field> list = Arrays.asList(fields);
        System.out.println(list.size());
        list.forEach(field -> {
            System.out.println("=================>");
            System.out.println(field.getName() + ", public: " + Modifier.isPublic(field.getModifiers()));
        });
//        modifiersTestClass.getDeclaredClasses();
    }

}
