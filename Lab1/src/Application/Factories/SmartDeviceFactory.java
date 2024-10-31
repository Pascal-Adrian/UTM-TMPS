package Application.Factories;

import Domain.Classes.SmartLightBulb;
import Domain.Classes.SmartSecurityCamera;
import Domain.Classes.SmartThermostat;
import Domain.Interfaces.ISmartDevice;

public class SmartDeviceFactory {
    public ISmartDevice getSmartDevice(String deviceType) {
        if (deviceType == null) {
            return null;
        }

        return switch (deviceType) {
            case "LIGHT_BULB" -> new SmartLightBulb();
            case "SECURITY_CAMERA" -> new SmartSecurityCamera();
            case "THERMOSTAT" -> new SmartThermostat();
            default -> null;
        };

    }
}
