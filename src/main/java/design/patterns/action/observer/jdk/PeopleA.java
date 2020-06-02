package design.patterns.action.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-05-22 3:17 下午 周五
 */
public class PeopleA implements Observer {
    @Override
    public void update(Observable observable, Object o) {
        System.out.println("AAAA");
    }
}
