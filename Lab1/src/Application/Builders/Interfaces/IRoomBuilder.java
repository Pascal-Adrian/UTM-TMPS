package Application.Builders.Interfaces;

import Domain.Interfaces.ISmartThermostat;
import Domain.Interfaces.IRoomController;
import Domain.Interfaces.ISmartLightBulb;
import Domain.Interfaces.ISmartSecurityCamera;

public interface IRoomBuilder extends IBuilder<IRoomController> {
    IRoomBuilder withName(String name);
    IRoomBuilder withThermostat(ISmartThermostat thermostat);
    IRoomBuilder withLight(ISmartLightBulb light);
    IRoomBuilder withSecurityCamera(ISmartSecurityCamera securityCamera);
}
