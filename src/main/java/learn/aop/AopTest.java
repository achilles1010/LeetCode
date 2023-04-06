package learn.aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-06 上午9:42 周二
 */
public class AopTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        UserService userService = (UserService) context.getBean("aopUserService");
        userService.addUser();
    }

}
