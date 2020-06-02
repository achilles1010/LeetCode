package design.patterns.action.state;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-04-26 10:32 上午 周日
 */
public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
