package learn.patterns.create.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Music player.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 4:54 下午 周五
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ProductBuilder {
    protected Product product = new Product();

    public abstract void buildName();
    public abstract void buildPrice();

    public Product createProduct() {
        this.buildName();
        this.buildPrice();
        return product;
    }


}
