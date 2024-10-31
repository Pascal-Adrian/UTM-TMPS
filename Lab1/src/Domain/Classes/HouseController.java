package Domain.Classes;

import Domain.Interfaces.IHouseController;
import Domain.Interfaces.IRoomController;

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
}
