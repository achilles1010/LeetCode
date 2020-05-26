package structural.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-04-23 5:47 下午 周四
 */
@Data
@AllArgsConstructor
public class RoundHole {
    private double radius;

    public boolean fits(RoundPeg roundPeg) {
        return this.getRadius() >= roundPeg.getRadius();
    }
}
