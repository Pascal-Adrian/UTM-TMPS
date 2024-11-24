package Domain.Interfaces;

public interface IUser extends ISubscriber {
    void setName(String name);
    String getName();
    void setSurname(String surname);
    String getSurname();
    void setPassword(String password);
    IHouseController getHouseController();
    void setHouseController(IHouseController houseController);
}
