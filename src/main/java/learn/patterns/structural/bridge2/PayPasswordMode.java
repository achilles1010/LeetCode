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
public class PayPasswordMode implements IPayMode{

    @Override
    public boolean security(String uId) {
        System.out.println(("密码支付，风控校验环境安全"));
        return true;
    }
}
