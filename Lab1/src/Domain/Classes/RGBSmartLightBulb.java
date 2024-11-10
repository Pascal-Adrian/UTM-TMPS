package Domain.Classes;

import Domain.Interfaces.IRGBSmartLightBulb;

public class RGBSmartLightBulb implements IRGBSmartLightBulb {
    private boolean state;
    private boolean connectionState;
    private int brightness;
    private int red;
    private int green;
    private int blue;

    public RGBSmartLightBulb() {
        this.state = false;
        this.connectionState = false;
        this.brightness = 80;
        this.red = 255;
        this.green = 255;
        this.blue = 255;
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

    public void setColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int[] getColor() {
        return new int[] {this.red, this.green, this.blue};
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
