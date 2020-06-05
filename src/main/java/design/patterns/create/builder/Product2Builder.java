package design.patterns.create.builder;

import lombok.Data;

/**
 * The type Music player.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 4:54 下午 周五
 */
@Data
public class Product2Builder extends ProductBuilder {
    @Override
    public void buildName() {
        product.setName("product2");
    }

    @Override
    public void buildPrice() {
        product.setPrice("product2-2222");
    }
}
