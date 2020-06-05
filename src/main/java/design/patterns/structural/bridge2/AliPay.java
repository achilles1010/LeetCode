package design.patterns.structural.bridge2;

import java.math.BigDecimal;

/**
 * The type Pay.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 2:53 下午 周五
 */
public class AliPay extends Pay{

    public AliPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        System.out.println("模拟支付宝渠道支付划账开始。uId：" + uId + " tradeId："+ tradeId +"amount：" +  amount);

        boolean security = payMode.security(uId);
        System.out.println("模拟支付宝渠道支付风控校验。uId：" + uId + " tradeId："+ tradeId +"security：" +  security);

        if (security) {
            System.out.println("模拟支付宝渠道支付划账拦截。uId：" + uId + " tradeId："+ tradeId +"amount：" +  amount);

            return "0001";
        }

        System.out.println("模拟支付宝渠道支付划账成功。uId：" + uId + " tradeId："+ tradeId +"amount：" +  amount);

        return "0000";
    }
}
