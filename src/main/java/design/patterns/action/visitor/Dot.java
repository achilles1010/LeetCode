package design.patterns.action.visitor;

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
public class Dot implements Shape{
    private int id;
    private int x;
    private int y;

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitDot(this);
    }
}
