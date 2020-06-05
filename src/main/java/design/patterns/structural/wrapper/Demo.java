package design.patterns.structural.wrapper;

import java.util.function.Function;

/**
 * The type Concrete component.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 5:22 下午 周五
 */
public class Demo {
    public static void main(String[] args) {
        Component concreteComponent, concreteDecoratorA, concreteDecoratorB;

        concreteComponent = new ConcreteComponent();
        concreteComponent.operation();
        System.out.println("----------------------------");

        concreteDecoratorA = new ConcreteDecoratorA(concreteComponent);
        concreteDecoratorA.operation();
        System.out.println("----------------------------");

        concreteDecoratorB = new ConcreteDecoratorB(concreteDecoratorA);
        concreteDecoratorB.operation();

        System.out.println("----------------------------");


        Component componentX = new ConcreteDecoratorB(new Component() {
            @Override
            public String apply(String s) {
                System.out.println("new Component apply");
                return s;
            }

            @Override
            public void operation() {
                System.out.println("test");
            }
        });


        Function<String, String> fun1 = s->{
            System.out.println("fun1:"+s);
            return s;
        };

        System.out.println("------------X----------------");

        componentX.andThen(fun1).apply("go");
        componentX.operation();

        System.out.println("------------X---------------");


        Component componentY = new ConcreteComponent();
        componentY.andThen(fun1).apply("test");

        System.out.println("----------------------------");
        componentY.compose(fun1).apply("test");

        componentY.operation();

    }
}
