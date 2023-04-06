package learn.patterns.structural.bridge.remotes;

import learn.patterns.structural.bridge.device.Device;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-04-24 11:52 上午 周五
 */
public class AdvanceRemote extends BasicRemote {

    public AdvanceRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println(("Remote: mute"));
        device.setVolume(0);
    }

}
