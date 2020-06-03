package design.patterns.action.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Pay by pay pal.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-03 10:47 上午 周三
 */
public class PayByPayPal implements PayStrategy {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    static {
        DATA_BASE.put("amanda1985", "amanda@ya.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }

    private boolean verify() {
        this.setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.println("Paying " + paymentAmount + " using PayPal");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        try {
            while (!signedIn) {
                System.out.println("Enter the user`s email");
                email = READER.readLine();
                System.out.println("Enter the password");
                password = READER.readLine();
                if (this.verify()) {
                    System.out.println("Data verification has been successful");
                } else {
                    System.out.println("Wrong email or password");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
