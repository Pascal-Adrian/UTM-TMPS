package Domain.Interfaces;

import java.util.List;

public interface IRoomController extends IRoomDevicesController, IRoomLightsController {
    void setName(String name);
    String getName();
    void setThermostat(ISmartThermostat thermostat);
    ISmartThermostat getThermostat();
    void setLights(List<ISmartLightBulb> lights);
    List<ISmartLightBulb> getLights();
    void setSecurityCameras(List<ISmartSecurityCamera> securityCameras);
    List<ISmartSecurityCamera> getSecurityCameras();
    void setSmartDevices(List<ISmartDevice> smartDevices);
    List<ISmartDevice> getSmartDevices();
}
