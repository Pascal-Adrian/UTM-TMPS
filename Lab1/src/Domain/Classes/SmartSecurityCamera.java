package Domain.Classes;

import Domain.Interfaces.ISmartDevice;

public class SmartSecurityCamera implements ISmartDevice {
    private boolean state;
    private boolean connectionState;
    private final int resolution;

    public SmartSecurityCamera() {
        this.state = false;
        this.connectionState = false;
        this.resolution = 1080;
    }

    public SmartSecurityCamera(int resolution) {
        this.state = false;
        this.connectionState = false;
        this.resolution = resolution;
    }

    public int getResolution() {
        return this.resolution;
    }

    public boolean getState() {
        return this.state;
    }

    public boolean getConnectionState() {
        return this.connectionState;
    }

    @Override
    public void on() {
        System.out.println("security camera turning on...");
        this.state = true;
    }

    @Override
    public void off() {
        System.out.println("security camera turning off...");
        this.state = false;
    }

    @Override
    public void connect() {
        System.out.println("security camera connecting...");
        this.connectionState = true;
    }

    @Override
    public void disconnect() {
        System.out.println("security camera disconnecting...");
        this.connectionState = false;
    }
}
