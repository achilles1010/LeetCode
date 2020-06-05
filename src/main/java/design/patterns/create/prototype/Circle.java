package design.patterns.create.prototype;

import java.util.Optional;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-05 3:14 下午 周五
 */
public class Circle extends Shape{
    public int radius;

    public Circle() {}

    public Circle(Circle target) {
        super(target);
        Optional.ofNullable(target).ifPresent(s-> this.radius = target.radius);
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Circle) || !super.equals(o))  {
            return false;
        }

        Circle shape = (Circle) o;
        return shape.radius == radius;
    }
}
