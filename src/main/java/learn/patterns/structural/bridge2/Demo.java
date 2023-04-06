package learn.patterns.structural.bridge2;

import java.math.BigDecimal;

/**
 * The type Pay.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 2:53 下午 周五
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay aliPay = new AliPay(new PayFingerprintMode());
        aliPay.transfer("jlu19dlxo111","100000109894",new BigDecimal(100));
    }

}
