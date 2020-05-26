package design.patterns.structural.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-04-23 5:47 下午 周四
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SquarePegAdapter extends RoundPeg {
    private SquarePeg squarePeg;

    @Override
    public double getRadius() {
        return Math.sqrt(Math.pow((squarePeg.getWidth() / 2),2)*2);
    }
}
