package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-06 上午9:42 周二
 */
@Aspect
@Component
public class TestAspect {

//    @Pointcut("execution (* aop.UserServiceImpl.addUser(..))")
    @Pointcut("execution (* aop..*.*(..))")
    private void aspect() {
        System.out.println("============进入aspect方法==============");
    }

    @Around("aspect()")
    public void around(JoinPoint joinPoint) throws Throwable {
        System.out.println("==========执行around前通知===============");
        long start = System.currentTimeMillis();
        ((ProceedingJoinPoint) joinPoint).proceed();
        System.out.println("执行时间:"+(System.currentTimeMillis()-start));
        System.out.println("==========执行around后通知===============");
    }

    @Before("aspect()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("==========执行前置通知===============");
    }

    @After("aspect()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("===========执行后置通知==============");
    }



}
