package design.patterns.structural.bridge2;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

/**
 * The type Pay.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 2:53 下午 周五
 */
@AllArgsConstructor
public abstract class Pay {

    /**
     * The Pay mode.
     */
    protected IPayMode payMode;

    /**
     * Transfer string.
     *
     * @param uId     the u id
     * @param tradeId the trade id
     * @param amount  the amount
     * @return the string
     */
    public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
