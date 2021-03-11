package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-11 下午3:49 周四
 */
@Component
public class MyBeanFactoryPostProcesser implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcesser() {
        super();
        System.out.println("这是BeanFactoryPostProcessor实现类构造器！！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor调用postProcessBeanFactory方法");
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("person");
        beanDefinition.getPropertyValues().addPropertyValue("phone", "110");
    }
}
