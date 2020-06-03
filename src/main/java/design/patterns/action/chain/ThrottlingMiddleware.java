package design.patterns.action.chain;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-03 2:12 下午 周三
 */
public class ThrottlingMiddleware extends Middleware {
    private int requestPerMinute;
    private int request;
    private long currentTime;

    @Override
    public boolean check(String email, String password) {
        if (System.currentTimeMillis() > currentTime + 6000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;

        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded");
            Thread.currentThread().stop();
        }

        return checkNext(email, password);
    }

    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }
}
