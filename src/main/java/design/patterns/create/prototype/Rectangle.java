package design.patterns.create.prototype;

import java.util.Optional;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-05 3:14 下午 周五
 */
public class Rectangle extends Shape{
    public int width;
    public int height;

    public Rectangle() {}

    public Rectangle(Rectangle target) {
        super(target);
        Optional.ofNullable(target).ifPresent(s-> {
            this.width = target.width;
            this.height = target.height;
        });
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rectangle) || !super.equals(o))  {
            return false;
        }

        Rectangle shape = (Rectangle) o;
        return shape.width == width || shape.height == height;
    }
}
