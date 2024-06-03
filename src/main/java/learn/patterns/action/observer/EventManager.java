//package learn.patterns.action.observer;
//
//import java.io.File;
//import java.util.*;
//import java.util.EventListener;
//
///**
// * @author daixulin
// * @version : v1.0
// * @date 2020-05-22 2:34 下午 周五
// */
//public class EventManager {
//    Map<String, List<java.util.EventListener>> listeners = new HashMap<>();
//
//    public EventManager(String... operations) {
//        for (String operation : operations) {
//            this.listeners.put(operation, new ArrayList<>());
//        }
//    }
//
//    public void subscribe(String eventType, java.util.EventListener listener) {
//        List<java.util.EventListener> users = listeners.get(eventType);
//        users.add(listener);
//    }
//
//    public void unsubscribe(String eventType, java.util.EventListener listener) {
//        List<java.util.EventListener> users = listeners.get(eventType);
//        users.remove(listener);
//    }
//
//    public void notify(String eventType, File file) {
//        List<java.util.EventListener> users = listeners.get(eventType);
//        for (EventListener listener : users) {
//            listener.update(eventType, file);
//        }
//    }
//}
