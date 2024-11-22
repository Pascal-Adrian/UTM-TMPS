package Application.Adapters;

import Domain.Interfaces.IHSLSmartLightBulb;
import Domain.Interfaces.IRGBSmartLightBulb;

import java.awt.*;

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
        int[] color = bulb.getColor();
        return convertHSLtoRGB(color[0], color[1], color[2]);
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

        return new int[]{h, s, l};
    }

    private int[] convertHSLtoRGB(int h, int s, int l) {
        float hue = h / 360.0f;
        float saturation = s / 100.0f;
        float lightness = l / 100.0f;

        float c = (1 - Math.abs(2 * lightness - 1)) * saturation;
        float x = c * (1 - Math.abs((hue * 6) % 2 - 1));
        float m = lightness - c / 2;

        float rPrime = 0, gPrime = 0, bPrime = 0;

        if (hue < 1.0 / 6) {
            rPrime = c;
            gPrime = x;
            bPrime = 0;
        } else if (hue < 2.0 / 6) {
            rPrime = x;
            gPrime = c;
            bPrime = 0;
        } else if (hue < 3.0 / 6) {
            rPrime = 0;
            gPrime = c;
            bPrime = x;
        } else if (hue < 4.0 / 6) {
            rPrime = 0;
            gPrime = x;
            bPrime = c;
        } else if (hue < 5.0 / 6) {
            rPrime = x;
            gPrime = 0;
            bPrime = c;
        } else {
            rPrime = c;
            gPrime = 0;
            bPrime = x;
        }

        int red = Math.round((rPrime + m) * 255);
        int green = Math.round((gPrime + m) * 255);
        int blue = Math.round((bPrime + m) * 255);

        return new int[]{red, green, blue};
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

    @Override
    public void setBrightness(int brightness) {
        bulb.setBrightness(brightness);
    }

    @Override
    public int getBrightness() {
        return bulb.getBrightness();
    }
}
