package design.patterns.structural.bridge.remotes;

import design.patterns.structural.bridge.device.Device;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-04-24 11:52 上午 周五
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BasicRemote implements Remote{
    protected Device device;

    @Override
    public void power() {
        System.out.println(("Remote: power toggle"));
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    @Override
    public void volumeDown() {
        System.out.println(("Remote: volume down"));
        device.setChannel(device.getVolume() - 10);
    }

    @Override
    public void volumeUp() {
        System.out.println(("Remote: volume up"));
        device.setChannel(device.getVolume() + 10);
    }

    @Override
    public void channelDown() {
        System.out.println(("Remote: channel up"));
        device.setChannel(device.getChannel() - 1);
    }

    @Override
    public void channelUp() {
        System.out.println(("Remote: channel up"));
        device.setChannel(device.getChannel() + 1);
    }
}
