package design.patterns.structural.wrapper;

/**
 * The type Concrete component.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 5:22 下午 周五
 */
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        this.methodA();
    }

    public void methodA() {
        System.out.println("ConcreteDecoratorA methodA");
    }
}
