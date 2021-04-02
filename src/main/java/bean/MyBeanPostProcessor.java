package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2021-03-11 下午3:35 周四
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

//    public MyBeanPostProcessor() {
//        super();
//        System.out.println("这是BeanPostProcessor实现类构造器！！");
//    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        if (o instanceof Person) {
            ((Person) o).setName("dddd");
            System.out.println("postProcessBeforeInitialization 修改 "+o);
        }

        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {

        System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        if (o instanceof Person) {
            ((Person) o).setName("sss");
            System.out.println("postProcessAfterInitialization 修改 "+o);
        }

        System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        return o;
    }
}
