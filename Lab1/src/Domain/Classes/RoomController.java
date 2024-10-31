package Domain.Classes;

import Domain.Interfaces.IRoomController;
import Domain.Interfaces.ISmartDevice;

import java.util.ArrayList;
import java.util.List;

public class RoomController implements IRoomController {
    private List<ISmartDevice> lights;
    private ISmartDevice thermostat;
    private List<ISmartDevice> securityCameras;
    private List<ISmartDevice> smartDevices;
    private String name;

    public RoomController(String name, List<ISmartDevice> lights, ISmartDevice thermostat, List<ISmartDevice> securityCameras) {
        this.name = name;
        this.lights = lights;
        this.thermostat = thermostat;
        this.securityCameras = securityCameras;
        this.smartDevices = new ArrayList<>();
        this.smartDevices.addAll(lights);
        this.smartDevices.add(thermostat);
        this.smartDevices.addAll(securityCameras);
    }

    public RoomController() {
        this.lights = new ArrayList<>();
        this.thermostat = null;
        this.securityCameras = new ArrayList<>();
        this.smartDevices = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLights(List<ISmartDevice> lights) {
        this.lights.clear();
        this.lights.addAll(lights);
    }

    public List<ISmartDevice> getLights() {
        return this.lights;
    }

    public void setThermostat(ISmartDevice thermostat) {
        this.thermostat = thermostat;
    }

    public ISmartDevice getThermostat() {
        return this.thermostat;
    }

    public void setSecurityCameras(List<ISmartDevice> securityCameras) {
        this.securityCameras.clear();
        this.securityCameras.addAll(securityCameras);
    }

    public List<ISmartDevice> getSecurityCameras() {
        return this.securityCameras;
    }

    @Override
    public void turnOnAllDevices() {
        for (ISmartDevice device : this.smartDevices) {
            device.on();
        }
    }

    @Override
    public void turnOffAllDevices() {
        for (ISmartDevice device : this.smartDevices) {
            device.off();
        }
    }

    @Override
    public void connectAllDevices() {
        for (ISmartDevice device : this.smartDevices) {
            device.connect();
        }
    }

    @Override
    public void disconnectAllDevices() {
        for (ISmartDevice device : this.smartDevices) {
            device.disconnect();
        }
    }

    @Override
    public void turnLightsOn() {
        for (ISmartDevice light : this.lights) {
            light.on();
        }
    }

    @Override
    public void turnLightsOff() {
        for (ISmartDevice light : this.lights) {
            light.off();
        }
    }
}