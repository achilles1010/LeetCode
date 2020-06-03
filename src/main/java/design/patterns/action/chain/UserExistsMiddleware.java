package design.patterns.action.chain;

import lombok.AllArgsConstructor;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-03 2:12 下午 周三
 */
@AllArgsConstructor
public class UserExistsMiddleware extends Middleware {

    private Server server;

    @Override
    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("this email is not registered");
            return false;
        }

        if (!server.isValidPassword(email, password)) {
            System.out.println("invalid password");
            return false;
        }

        return checkNext(email, password);
    }
}
