package structural.bridge.device;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-04-24 11:43 上午 周五
 */
public interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(int channel);

    void printStatus();
}
