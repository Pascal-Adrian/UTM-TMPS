package Application.Adapters;

import Domain.Interfaces.IHSLSmartLightBulb;
import Domain.Interfaces.IRGBSmartLightBulb;

public class RGBtoHSLSmartLightBulbAdapter implements IRGBSmartLightBulb {
    private IHSLSmartLightBulb bulb;

    public RGBtoHSLSmartLightBulbAdapter(IHSLSmartLightBulb bulb) {
        this.bulb = bulb;
    }

    @Override
    public void setColor(int red, int green, int blue) {
        int[] hsl = convertRGBtoHSL(red, green, blue);
        bulb.setColor(hsl[0], hsl[1], hsl[2]);
    }

    @Override
    public int[] getColor() {
        return bulb.getColor();
    }

    private int[] convertRGBtoHSL(int red, int green, int blue) {
        int r = red / 255;
        int g = green / 255;
        int b = blue / 255;

        int max = Math.max(r, Math.max(g, b));
        int min = Math.min(r, Math.min(g, b));
        int h = 0;
        int s = 0;
        int l = (max + min) / 2;

        if (max == min) {
            h = s = 0;
        } else {
            int d = max - min;
            s = l > 0.5 ? d / (2 - max - min) : d / (max + min);
            if (max == r) {
                h = (g - b) / d + (g < b ? 6 : 0);
            } else if (max == g) {
                h = (b - r) / d + 2;
            } else if (max == b) {
                h = (r - g) / d + 4;
            }
            h /= 6;
        }

        return new int[] {h, s, l};
    }

    @Override
    public void on() {
        bulb.on();
    }

    @Override
    public void off() {
        bulb.off();
    }

    @Override
    public void connect() {
        bulb.connect();
    }

    @Override
    public void disconnect() {
        bulb.disconnect();
    }

    @Override
    public boolean getState() {
        return bulb.getState();
    }

    @Override
    public boolean getConnectionState() {
        return bulb.getConnectionState();
    }
}
