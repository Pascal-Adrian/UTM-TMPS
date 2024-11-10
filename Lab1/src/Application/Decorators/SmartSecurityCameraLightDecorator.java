package Application.Decorators;

import Domain.Interfaces.ISmartSecurityCamera;

import java.time.LocalTime;

public class SmartSecurityCameraLightDecorator implements ISmartSecurityCamera {
    private ISmartSecurityCamera camera;
    private boolean lightState;

    public SmartSecurityCameraLightDecorator(ISmartSecurityCamera camera) {
        this.camera = camera;
    }

    @Override
    public void on() {
        this.handleLight();
        camera.on();
    }

    @Override
    public void off() {
        this.turnLightOff();
        camera.off();
    }

    @Override
    public void connect() {
        camera.connect();
    }

    @Override
    public void disconnect() {
        camera.disconnect();
    }

    @Override
    public boolean getState() {
        return camera.getState();
    }

    @Override
    public boolean getConnectionState() {
        return camera.getConnectionState();
    }

    @Override
    public int getResolution() {
        return camera.getResolution();
    }

    private void turnLightOn() {
        lightState = true;
        System.out.println("Turning on security camera light...");
    }

    private void turnLightOff() {
        lightState = false;
        System.out.println("Turning off security camera light...");
    }

    private void handleLight() {
        LocalTime time = LocalTime.now();
        if (time.isAfter(LocalTime.of(18, 0)) || time.isBefore(LocalTime.of(6, 0))) {
            turnLightOn();
        } else {
            turnLightOff();
        }
    }
}
