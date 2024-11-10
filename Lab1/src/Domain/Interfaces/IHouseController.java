package Domain.Interfaces;

import java.util.List;

public interface IHouseController {
    void setRoomControllers(List<IRoomController> roomControllers);
    List<IRoomController> getRoomControllers();
    void addRoomController(IRoomController roomController);
    void removeRoomController(IRoomController roomController);
    void removeAllRoomControllers();
    void turnAllLightsOff();
    void turnAllLightsOn();
    void connectAll();
    void disconnectAll();
    void turnAllDevicesOff();
    void turnAllDevicesOn();
    void turnLightsOn(String roomName);
    void turnLightsOff(String roomName);
    void setTemperature(int temperature);
    void setTemperature(String roomName, int temperature);
    int getTemperature(String roomName);
}
