package design.patterns.action.strategy;

import lombok.Data;

/**
 * The type Pay by pay pal.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-03 10:47 上午 周三
 */
@Data
public class Order {
   private int totalCost = 0;
   private boolean isClosed = false;

   public void processOrder(PayStrategy strategy) {
       strategy.collectPaymentDetails();
   }

   public void setTotalCost(int cost) {
       this.totalCost += cost;
   }

   public void setClosed() {
       isClosed = true;
   }
}
