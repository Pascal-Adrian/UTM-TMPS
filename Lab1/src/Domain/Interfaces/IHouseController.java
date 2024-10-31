package Domain.Interfaces;

import java.util.List;

public interface IHouseController {
    void setRoomControllers(List<IRoomController> roomControllers);
    List<IRoomController> getRoomControllers();
}
