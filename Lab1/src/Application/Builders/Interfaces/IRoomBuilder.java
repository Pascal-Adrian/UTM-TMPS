package Application.Builders.Interfaces;

import Domain.Interfaces.IRoomController;
import Domain.Interfaces.ISmartDevice;

public interface IRoomBuilder extends IBuilder<IRoomController> {
    IRoomBuilder withName(String name);
    IRoomBuilder withThermostat(ISmartDevice thermostat);
    IRoomBuilder withLight(ISmartDevice light);
    IRoomBuilder withSecurityCamera(ISmartDevice securityCamera);
}
