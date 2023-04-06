package learn.patterns.action.visitor;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-04 10:50 上午 周四
 */
@NoArgsConstructor
@Getter
public class Rectangle implements Shape{
    private int id;
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int id, int x, int y, int width, int height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitRectangle(this);
    }
}
