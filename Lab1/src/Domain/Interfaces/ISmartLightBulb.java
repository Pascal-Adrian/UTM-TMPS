package Domain.Interfaces;

public interface ISmartLightBulb extends ISmartDevice {
    void setBrightness(int brightness);
    int getBrightness();
}
