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

    public void setRoomControllers(List<IRoomController> roomControllers) {
        this.roomControllers = roomControllers;
    }

    public List<IRoomController> getRoomControllers() {
        return roomControllers;
    }

    public void addRoomController(IRoomController roomController) {
        this.roomControllers.add(roomController);
    }

    public void removeRoomController(IRoomController roomController) {
        this.roomControllers.remove(roomController);
    }

    public void removeAllRoomControllers() {
        this.roomControllers.clear();
    }

    public void turnAllLightsOff() {
        for (IRoomController controller : roomControllers) {
            controller.turnLightsOn();
        }
    }

    public void turnAllLightsOn() {
        for (IRoomController controller : roomControllers) {
            controller.turnLightsOn();
        }
    }

    public void connectAll() {
        for (IRoomController controller : roomControllers) {
            controller.connectAllDevices();
        }
    }

    public void disconnectAll() {
        for (IRoomController controller : roomControllers) {
            controller.disconnectAllDevices();
        }
    }

    public void turnAllDevicesOff() {
        for (IRoomController controller : roomControllers) {
            controller.turnOffAllDevices();
        }
    }

    public void turnAllDevicesOn() {
        for (IRoomController controller : roomControllers) {
            controller.turnOnAllDevices();
        }
    }
}
