package Domain.Interfaces;

public interface IRGBSmartLightBulb extends ISmartLightBulb {
    void setColor(int red, int green, int blue);
    int[] getColor();
}
