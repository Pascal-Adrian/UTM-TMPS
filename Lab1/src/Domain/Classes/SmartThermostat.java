package Domain.Classes;

import Domain.Interfaces.ISmartDevice;
import Domain.Interfaces.ISmartThermostat;

public class SmartThermostat implements ISmartThermostat {
    private boolean state;
    private boolean connectionState;
    private int temperature;

    public SmartThermostat() {
        this.state = false;
        this.connectionState = false;
        this.temperature = 20;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return this.temperature;
    }

    @Override
    public boolean getState() {
        return this.state;
    }

    @Override
    public boolean getConnectionState() {
        return this.connectionState;
    }

    @Override
    public void on() {
        System.out.println("thermostat turning on...");
        this.state = true;
    }

    @Override
    public void off() {
        System.out.println("thermostat turning off...");
        this.state = false;
    }

    @Override
    public void connect() {
        System.out.println("thermostat connecting...");
        this.connectionState = true;
    }

    @Override
    public void disconnect() {
        System.out.println("thermostat disconnecting...");
        this.connectionState = false;
    }
}
