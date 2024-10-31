package Application.Builders.Classes;

import Application.Builders.Interfaces.IRoomBuilder;
import Domain.Classes.RoomController;
import Domain.Interfaces.IRoomController;
import Domain.Interfaces.ISmartDevice;

public class RoomBuilder implements IRoomBuilder {
    private IRoomController roomController;

    public RoomBuilder() {
        this.roomController = new RoomController();
    }

    @Override
    public IRoomBuilder withName(String name) {
        this.roomController.setName(name);
        return this;
    }

    @Override
    public IRoomBuilder withThermostat(ISmartDevice thermostat) {
        this.roomController.setThermostat(thermostat);
        return this;
    }

    @Override
    public IRoomBuilder withLight(ISmartDevice light) {
        this.roomController.getLights().add(light);
        return this;
    }

    @Override
    public IRoomBuilder withSecurityCamera(ISmartDevice securityCamera) {
        this.roomController.getSecurityCameras().add(securityCamera);
        return this;
    }

    @Override
    public IRoomBuilder reset() {
        this.roomController = new RoomController();
        return this;
    }

    @Override
    public IRoomController build() {
        return this.roomController;
    }
}
