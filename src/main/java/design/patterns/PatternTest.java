package design.patterns;

import design.patterns.action.strategy.function.BizService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-11 下午3:54 周四
 */
public class PatternTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PatternConfig.class);
        BizService bizService = (BizService) context.getBean("bizService");
        System.out.println(bizService.getCheckResult("two"));
    }

}
