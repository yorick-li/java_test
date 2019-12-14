package reflection.util;

import com.yorick.pro.java_test.java_base.reflection.model.ObjChangeLog;
import com.yorick.pro.java_test.java_base.reflection.util.CompareSameClassObjectUtils;
import org.junit.Test;
import reflection.model.User;

import java.util.List;

import static com.yorick.pro.java_test.java_base.reflection.util.CompareSameClassObjectUtils.compare;

/**
 * 测试类
 */
public class TestCompareSameClassObjectUtils {

    @Test
    public void testCompare() {
        User oldU = new User();
        User newU = new User();

//        User oldU = new User();
//        oldU.setId(1L);
//        User newU = new User();

//        User oldU = new User();
//        oldU.setId(1L);
//        User newU = new User();
//        newU.setName("newU");

//        User oldU = new User();
//        oldU.setId(1L);
//        oldU.setSex("男");
//        User newU = new User();
//        newU.setName("newU");
//        newU.setSex("女");

        List<ObjChangeLog> logs = CompareSameClassObjectUtils.compare(oldU, newU);
        System.out.println(logs);
    }

}
