package learn.patterns.action.visitor;

/**
 * The interface Visitor.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-04 10:50 上午 周四
 */
public interface Visitor {
    /**
     * Visit dot string.
     *
     * @param dot the dot
     * @return the string
     */
    String visitDot(Dot dot);

    /**
     * Visit circle string.
     *
     * @param circle the circle
     * @return the string
     */
    String visitCircle(Circle circle);

    /**
     * Visit rectangle string.
     *
     * @param rectangle the rectangle
     * @return the string
     */
    String visitRectangle(Rectangle rectangle);

    /**
     * Visit compound graphic string.
     *
     * @param cg the cg
     * @return the string
     */
    String visitCompoundGraphic(CompoundShape cg);
}
