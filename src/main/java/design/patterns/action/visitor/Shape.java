package design.patterns.action.visitor;

/**
 * The interface Shape.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-04 10:50 上午 周四
 */
public interface Shape {
    /**
     * Move.
     *
     * @param x the x
     * @param y the y
     */
    void move(int x, int y);

    /**
     * Draw.
     */
    void draw();

    /**
     * Accept string.
     *
     * @param visitor the visitor
     * @return the string
     */
    String accept(Visitor visitor);
}
