package design.patterns.structural.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-04-23 5:47 下午 周四
 */
@Data
@AllArgsConstructor
public class SquarePeg {
    private double width;

    public double getSquare() {
        return Math.pow(this.width, 2);
    }
}
