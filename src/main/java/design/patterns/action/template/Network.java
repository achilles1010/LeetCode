package design.patterns.action.template;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-02 2:48 下午 周二
 */
public abstract class Network {
    String userName;
    String password;

    Network() {};

    public boolean post(String message) {
        if (logIn(this.userName, this.password)) {
            boolean result = this.sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract boolean logIn(String userName, String password);
    abstract boolean sendData(byte[] data);
    abstract void logOut();
}
