package design.patterns.action.chain;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-03 2:09 下午 周三
 */
public abstract class Middleware {
    private Middleware next;

    public Middleware linkWith(Middleware next)  {
        this.next = next;
        return next;
    }

    public abstract boolean check(String email, String password);

    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}
