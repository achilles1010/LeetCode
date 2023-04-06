package learn.patterns.structural.wrapper;

/**
 * The type Concrete component.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 5:22 下午 周五
 */
public class ConcreteComponent extends Component {

    @Override
    public void operation() {
        System.out.println("ConcreteComponent operation");
    }

    @Override
    public String apply(String s) {
        System.out.println("ConcreteComponent apply :" + s);
        return s;
    }
}
