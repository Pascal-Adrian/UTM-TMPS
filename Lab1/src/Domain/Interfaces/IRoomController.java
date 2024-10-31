package Domain.Interfaces;

import java.util.List;

public interface IRoomController extends IRoomDevicesController, IRoomLightsController {
    void setName(String name);
    String getName();
    void setThermostat(ISmartDevice thermostat);
    ISmartDevice getThermostat();
    void setLights(List<ISmartDevice> lights);
    List<ISmartDevice> getLights();
    void setSecurityCameras(List<ISmartDevice> securityCameras);
    List<ISmartDevice> getSecurityCameras();
}
