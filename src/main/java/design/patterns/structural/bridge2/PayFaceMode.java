package design.patterns.structural.bridge2;

import lombok.AllArgsConstructor;

/**
 * The type Pay.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 2:53 下午 周五
 */
@AllArgsConstructor
public class PayFaceMode implements IPayMode{

    @Override
    public boolean security(String uId) {
        System.out.println(("人脸支付，风控校验脸部识别"));
        return true;
    }
}
