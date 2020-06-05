package design.patterns.structural.wrapper;

/**
 * The type Concrete component.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 5:22 下午 周五
 */
public class Decorator extends Component {
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }

    @Override
    public String apply(String s) {
        System.out.println("Decorator apply :" + s);
        return s;
    }
}
