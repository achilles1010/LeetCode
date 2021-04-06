package aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-11 下午3:54 周四
 */
@Configuration
@ComponentScan(basePackages = "aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
