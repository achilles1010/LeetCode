package learn.bean;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-11 下午3:53 周四
 */

import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
//@Component
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

//    public MyInstantiationAwareBeanPostProcessor() {
//        super();
//        System.out .println("这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！");
//    }
//
//    // 接口方法、实例化Bean之前调用
//    @Override
//    public Object postProcessBeforeInstantiation(Class beanClass,
//                                                 String beanName) throws BeansException {
//        System.out
//                .println("InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法");
//        return null;
//    }
//
//    // 接口方法、实例化Bean之后调用
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName)
//            throws BeansException {
//        System.out
//                .println("InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法");
//        return bean;
//    }
//
//    // 接口方法、设置某个属性时调用
//    @Override
//    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
//            throws BeansException {
//        System.out.println("InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法");
//        return pvs;
//    }
}
