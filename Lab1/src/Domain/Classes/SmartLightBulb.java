package Domain.Classes;

import Domain.Interfaces.ISmartLightBulb;

public class SmartLightBulb implements ISmartLightBulb {
    private boolean state;
    private boolean connectionState;
    private int brightness;

    public SmartLightBulb() {
        this.state = false;
        this.connectionState = false;
        this.brightness = 80;
    }

    @Override
    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    @Override
    public int getBrightness() {
        return this.brightness;
    }

    public boolean getState() {
        return this.state;
    }

    public boolean getConnectionState() {
        return this.connectionState;
    }

    @Override
    public void on() {
        System.out.println("light bulb turning on...");
        this.state = true;
    }

    @Override
    public void off() {
        System.out.println("light bulb turning off...");
        this.state = false;
    }

    @Override
    public void connect() {
        System.out.println("light bulb connecting...");
        this.connectionState = true;
    }

    @Override
    public void disconnect() {
        System.out.println("light bulb disconnecting...");
        this.connectionState = false;
    }
}
