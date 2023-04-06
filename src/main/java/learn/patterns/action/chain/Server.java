package learn.patterns.action.chain;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-03 2:12 下午 周三
 */
public class Server {
    private Map<String, String> users = new HashMap<>();

    @Setter
    private Middleware middleware;

    public boolean logIn(String email, String password) {
       if (middleware.check(email, password))  {
           System.out.println("Authorization have ben successful");

           return true;
       } else {
           return false;
       }
    }

    public void register(String email, String password) {
        users.put(email, password);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }
}
