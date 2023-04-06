package learn.patterns.structural.adapter;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-04-23 5:47 下午 周四
 */
public class AdapterDemo {
    public static void main(String[] args) {

        RoundHole hole = new RoundHole(5);
        RoundPeg reg = new RoundPeg(5);

        if (hole.fits(reg)) {
            System.out.println(("Round peg r5 fits round hole r5"));
        }

        SquarePeg smallPeg =  new SquarePeg(2);
        SquarePeg largePeg =  new SquarePeg(20);
        // hole.fits(smallSquarePeg); // Won`t compile

        SquarePegAdapter smallSquarePegAdapter = new SquarePegAdapter(smallPeg);
        SquarePegAdapter largeSquarePegAdapter = new SquarePegAdapter(largePeg);

        if (hole.fits(smallSquarePegAdapter)) {
            System.out.println(("Square peg w2 fits round hole r5."));
        }

        if (!hole.fits(largeSquarePegAdapter)) {
            System.out.println(("Square peg w20 does not fits round hole r5."));
        }
    }
}
