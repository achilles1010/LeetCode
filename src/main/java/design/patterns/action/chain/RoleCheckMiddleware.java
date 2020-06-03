package design.patterns.action.chain;

import lombok.AllArgsConstructor;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-03 2:12 下午 周三
 */
@AllArgsConstructor
public class RoleCheckMiddleware extends Middleware {

    @Override
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("hello admin");
            return true;
        }

        System.out.println("hello user");

        return checkNext(email, password);
    }
}
