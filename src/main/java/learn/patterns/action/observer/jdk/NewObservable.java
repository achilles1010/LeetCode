package learn.patterns.action.observer.jdk;

import java.util.Observable;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-05-22 3:17 下午 周五
 */
public class NewObservable extends Observable {
    public void upadte() {
        this.setChanged();
        notifyObservers();
    }

    public static void main(String[] args) {
        NewObservable newObservable = new NewObservable();
        newObservable.addObserver(new PeopleA());
        newObservable.addObserver(new PeopleB());
        newObservable.upadte();
    }
}
