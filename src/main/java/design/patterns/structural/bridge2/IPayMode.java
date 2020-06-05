package design.patterns.structural.bridge2;

/**
 * The interface Pay mode.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 2:53 下午 周五
 */
public interface IPayMode {
    /**
     * Security boolean.
     *
     * @param uId the u id
     * @return the boolean
     */
    boolean security(String uId);
}
