package learn.patterns.create.builder;

/**
 * The type Music player.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 4:54 下午 周五
 */
public class ProductDemo {
    public static void main(String[] args) {
        Product product = new Product1Builder().createProduct();
        System.out.println(product.toString());
    }
}
