package Domain.Classes;

import Domain.Interfaces.IHouseController;
import Domain.Interfaces.IUser;

public class User implements IUser {
    private String name;
    private String surname;
    private String password;
    private IHouseController houseController;

    public User(String name, String surname, String password, IHouseController houseController) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.houseController = houseController;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public IHouseController getHouseController() {
        return houseController;
    }

    @Override
    public void setHouseController(IHouseController houseController) {
        this.houseController = houseController;
    }

    @Override
    public void update(String message) {
        System.out.println("User " + name + " " + surname + " received the following message: " + message);
    }
}
