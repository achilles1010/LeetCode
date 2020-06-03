package design.patterns.action.strategy;

import lombok.Data;

/**
 * The type Pay by pay pal.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-03 10:47 上午 周三
 */
@Data
public class CreditCard {
    private int amount;
    private String number;
    private String date;
    private String cvv;

    public CreditCard(String number, String date, String cvv) {
        this.amount = 100000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }
}
