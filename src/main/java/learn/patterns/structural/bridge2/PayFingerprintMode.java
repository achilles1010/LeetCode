package learn.patterns.structural.bridge2;

import lombok.AllArgsConstructor;

/**
 * The type Pay.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 2:53 下午 周五
 */
@AllArgsConstructor
public class PayFingerprintMode implements IPayMode{

    @Override
    public boolean security(String uId) {
        System.out.println(("指纹支付，风控校验指纹识别"));
        return true;
    }
}
