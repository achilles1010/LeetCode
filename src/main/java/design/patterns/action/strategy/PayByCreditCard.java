package design.patterns.action.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The type Pay by pay pal.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-03 10:47 上午 周三
 */
public class PayByCreditCard implements PayStrategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard creditCard;

    private boolean cardIsPresent() {
        return creditCard != null;
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()) {
            System.out.println("Paying " + paymentAmount + " using Credit card");
            creditCard.setAmount(creditCard.getAmount() - paymentAmount);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        try {
            System.out.println("Enter the card number:");
            String number = READER.readLine();
            System.out.println("Enter the card expiration data 'mm/yy':");
            String data = READER.readLine();
            System.out.println("Enter the CVV code:");
            String cvv = READER.readLine();
            creditCard = new CreditCard(number, data, cvv);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
