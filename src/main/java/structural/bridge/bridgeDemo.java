package structural.bridge;

import structural.bridge.device.Device;
import structural.bridge.device.Radio;
import structural.bridge.device.Tv;
import structural.bridge.remotes.AdvanceRemote;
import structural.bridge.remotes.BasicRemote;
import lombok.Data;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-04-24 11:52 上午 周五
 */
@Data
public class bridgeDemo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvanceRemote advancedRemote = new AdvanceRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}

