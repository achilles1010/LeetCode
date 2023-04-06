package learn.patterns.create.prototype;


import java.util.ArrayList;
import java.util.List;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-05 3:14 下午 周五
 */
public class Demo {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle  circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        // 克隆
        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);


        BundledShapeCache cache = new BundledShapeCache();
        Shape shape1 = cache.get("big green circle");
        Shape shape2 = cache.get("medium blue rectangle");
        Shape shape3 = cache.get("medium blue rectangle");

        if (shape1 != shape2 && !shape1.equals(shape2)) {
            System.out.println("Big green circle != Medium blue rectangle (yay!)");
        } else {
            System.out.println("Big green circle == Medium blue rectangle (booo!)");
        }

        if (shape2 != shape3) {
            System.out.println("Medium blue rectangles are two different objects (yay!)");
            if (shape2.equals(shape3)) {
                System.out.println("And they are identical (yay!)");
            } else {
                System.out.println("But they are not identical (booo!)");
            }
        } else {
            System.out.println("Rectangle objects are the same (booo!)");
        }
    }

    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        shapes.forEach(shape -> shapesCopy.add(shape.clone()));

        shapes.forEach(shape -> {
            int i = shapes.indexOf(shape);
            if (shape != shapesCopy.get(i)) {
                System.out.println(i + ": shapes are different objects (yay)");
                if (shape.equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }

        });
    }
}
