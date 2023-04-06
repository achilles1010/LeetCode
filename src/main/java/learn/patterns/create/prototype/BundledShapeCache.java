package learn.patterns.create.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-05 3:14 下午 周五
 */
public class BundledShapeCache {
    private Map<String, Shape> cache = new HashMap<>();

    public BundledShapeCache() {
        Circle circle = new Circle();
        circle.x = 5;
        circle.y = 7;
        circle.radius = 45;
        circle.color = "green";

        Rectangle rectangle = new Rectangle();
        rectangle.x = 6;
        rectangle.y = 7;
        rectangle.width = 8;
        rectangle.height = 10;
        rectangle.color = "blue";

        cache.put("big green circle", circle);
        cache.put("medium blue rectangle", rectangle);
    }

    public Shape put(String key, Shape shape) {
        cache.put(key, shape);
        return shape;
    }

    public Shape get(String key) {
        return cache.get(key).clone();
    }
}
