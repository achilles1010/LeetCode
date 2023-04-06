package learn.patterns.create.prototype;

import java.util.Optional;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-05 3:14 下午 周五
 */
public abstract class Shape {
    public int x;
    public int y;
    public String color;

    public Shape() {}

    public Shape(Shape target) {
        Optional.ofNullable(target).ifPresent(s->{
            this.x = s.x;
            this.y = s.y;
            this.color = s.color;
        });
    }

    @Override
    public abstract Shape clone();

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof  Shape)) {
            return false;
        }
        Shape shape = (Shape) object;
        return shape.x == x && shape.y == y && color.equals(shape.color);
    }
}
