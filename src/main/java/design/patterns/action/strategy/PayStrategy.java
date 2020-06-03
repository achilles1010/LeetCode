package design.patterns.action.strategy;

/**
 * The interface Pay strategy.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-03 10:45 上午 周三
 */
public interface PayStrategy {
    /**
     * Pay boolean.
     *
     * @param paymentAmount the payment amount
     * @return the boolean
     */
    boolean pay(int paymentAmount);

    /**
     * Collect payment details.
     */
    void collectPaymentDetails();
}
