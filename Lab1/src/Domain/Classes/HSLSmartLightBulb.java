package Domain.Classes;

import Domain.Interfaces.IHSLSmartLightBulb;

public class HSLSmartLightBulb implements IHSLSmartLightBulb {
    private boolean state;
    private boolean connectionState;
    private int brightness;
    private int hue;
    private int saturation;
    private int lightness;

    public HSLSmartLightBulb() {
        this.state = false;
        this.connectionState = false;
        this.brightness = 80;
        this.hue = 0;
        this.saturation = 0;
        this.lightness = 0;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public boolean getState() {
        return this.state;
    }

    public boolean getConnectionState() {
        return this.connectionState;
    }

    public void setColor(int hue, int saturation, int lightness) {
        this.hue = hue;
        this.saturation = saturation;
        this.lightness = lightness;
    }

    public int[] getColor() {
        return new int[] {this.hue, this.saturation, this.lightness};
    }

    public void on() {
        System.out.println("light bulb turning on...");
        this.state = true;
    }

    public void off() {
        System.out.println("light bulb turning off...");
        this.state = false;
    }

    public void connect() {
        System.out.println("light bulb connecting...");
        this.connectionState = true;
    }

    public void disconnect() {
        System.out.println("light bulb disconnecting...");
        this.connectionState = false;
    }
}
