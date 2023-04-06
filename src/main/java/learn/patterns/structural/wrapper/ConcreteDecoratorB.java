package learn.patterns.structural.wrapper;

/**
 * The type Concrete component.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 5:22 下午 周五
 */
public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        this.methodB();
    }

    public void methodB() {
        System.out.println("ConcreteDecoratorB methodB");
    }

//    @Override
//    public String apply(String s) {
//        System.out.println("ConcreteDecoratorB apply :" + s);
//        return s;
//    }
}
