package learn.patterns.action.visitor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-04 10:50 上午 周四
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Circle extends Dot{
    private int radius;

    public Circle(int id, int x, int y, int radius) {
        super(id, x, y);
        this.radius = radius;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCircle(this);
    }
}
