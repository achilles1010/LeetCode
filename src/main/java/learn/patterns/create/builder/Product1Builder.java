package learn.patterns.create.builder;

import lombok.Data;

/**
 * The type Music player.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 4:54 下午 周五
 */
@Data
public class Product1Builder extends ProductBuilder {
    @Override
    public void buildName() {
        product.setName("product1");
    }

    @Override
    public void buildPrice() {
        product.setPrice("product1-1111");
    }
}
