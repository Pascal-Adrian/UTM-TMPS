package Domain.Classes;

import Domain.Interfaces.IHouseController;
import Domain.Interfaces.IRoomController;
import Domain.Interfaces.ISmartDevice;
import Domain.Interfaces.ISmartLightBulb;

import java.util.ArrayList;
import java.util.List;

public class HouseController implements IHouseController {
    private IHouseController houseController;
    private List<IRoomController> roomControllers;

    private HouseController() {
        this.roomControllers = new ArrayList<>();
    }

    public IHouseController getInstance() {
        if (houseController == null) {
            houseController = new HouseController();
        }

        return houseController;
    }

    @Override
    public void setRoomControllers(List<IRoomController> roomControllers) {
        this.roomControllers = roomControllers;
    }

    @Override
    public List<IRoomController> getRoomControllers() {
        return roomControllers;
    }

    @Override
    public void addRoomController(IRoomController roomController) {
        this.roomControllers.add(roomController);
    }

    @Override
    public void removeRoomController(IRoomController roomController) {
        this.roomControllers.remove(roomController);
    }

    @Override
    public void removeAllRoomControllers() {
        this.roomControllers.clear();
    }

    @Override
    public void turnAllLightsOff() {
        for (IRoomController controller : roomControllers) {
            controller.turnLightsOn();
        }
    }

    @Override
    public void turnAllLightsOn() {
        for (IRoomController controller : roomControllers) {
            controller.turnLightsOn();
        }
    }

    @Override
    public void connectAll() {
        for (IRoomController controller : roomControllers) {
            controller.connectAllDevices();
        }
    }

    @Override
    public void disconnectAll() {
        for (IRoomController controller : roomControllers) {
            controller.disconnectAllDevices();
        }
    }

    @Override
    public void turnAllDevicesOff() {
        for (IRoomController controller : roomControllers) {
            controller.turnOffAllDevices();
        }
    }

    @Override
    public void turnAllDevicesOn() {
        for (IRoomController controller : roomControllers) {
            controller.turnOnAllDevices();
        }
    }


    public void turnLightsOn(String roomName) {
        for (IRoomController controller : roomControllers) {
            if (controller.getName().equals(roomName)) {
                controller.turnLightsOn();
            }
        }
    }

    public void turnLightsOff(String roomName) {
        for (IRoomController controller : roomControllers) {
            if (controller.getName().equals(roomName)) {
                controller.turnLightsOff();
            }
        }
    }

    @Override
    public void setTemperature(String roomName, int temperature) {
        for (IRoomController controller : roomControllers) {
            if (controller.getName().equals(roomName)) {
                controller.getThermostat().setTemperature(temperature);
            }
        }
    }

    @Override
    public void setTemperature(int temperature) {
        for (IRoomController controller : roomControllers) {
                controller.getThermostat().setTemperature(temperature);
        }
    }

    @Override
    public int getTemperature(String roomName) {
        for (IRoomController controller : roomControllers) {
            if (controller.getName().equals(roomName)) {
                return controller.getThermostat().getTemperature();
            }
        }

        return -1;
    }
}
