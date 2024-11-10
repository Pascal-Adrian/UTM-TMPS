package Domain.Interfaces;

public interface IHSLSmartLightBulb extends ISmartLightBulb {
    void setColor(int hue, int saturation, int lightness);
    int[] getColor();
}
