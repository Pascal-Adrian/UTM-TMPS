# Creational Design Patterns


## Author: Pascal Adrian

----

## Objectives:

1. Study and understand the Creational Design Patterns.

2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.

3. Use some creational design patterns for object instantiation in a sample project.


## Domain: **Smart Home Controller**

For this project I have chosen to implement a fictional Smart Home Controller, because it is a very wide domain
and it can be easily extended with new features, thus making it a good candidate for demonstrating the use of
Design Patterns. For demonstrational purposes, I implemented only a couple features that enable me to use and 
demonstrate the Factory, Builder and Singleton patterns. The features implemented are the following: 

- **ISmartDevice** interface, which is implemented by all smart devices in the system (SmartLight, SmartThermostat, etc.);
- **IRoomController** interface, which is implemented by **RoomController** class and is used to control the devices in a room;
- **IHomeController** interface, which is implemented by **HomeController** class and is used to control the rooms in the house;


## Used Design Patterns:

1. **Builder Pattern** 

    A **creational** design pattern that lets you construct complex objects step by step. The pattern allows you to produce 
    different types and representations of an object using the same construction code.
    ![Builder Pattern Diagram](https://refactoring.guru/images/patterns/diagrams/builder/structure.png)

2. **Factory Pattern**

    A **creational** design pattern that provides an interface for creating objects in a superclass, but allows subclasses to 
    alter the type of objects that will be created.    
    ![Factory Pattern Diagram](https://refactoring.guru/images/patterns/diagrams/factory-method/structure.png)

3. **Singleton Pattern**

    A **creational** design pattern that lets you ensure that a class has only one instance, 
    while providing a global access point to this instance.
    ![Singleton Pattern Diagram](https://refactoring.guru/images/patterns/diagrams/singleton/structure-en.png)

## Implementation

Given my domain, I have implemented the **Builder**, **Factory** and **Singleton** patterns to create the objects in a 
simpler and more organized way. This patterns ensure code maintainability and scalability, by providing a clear separation
of concerns and a clear way of creating objects.

1. Builder Pattern 

    The pattern is used to create `RoomController` objects, given the fact that a `RoomController` object can contain multiple
    objects that inherit the common interface `ISmartDevice` with different configurations and implementations. The `RoomController`
    class is used to control the devices in a room by being aware of the common interface. The `RoomBuilder` class is used to create
    `RoomController` objects with different configurations of devices.

```java
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
```

2. Factory Pattern
    The pattern is used to create `ISmartDevice` objects, given the fact that they share a common interface with some basic
    functionality. The `SmartDeviceFactory` class is used to create different types of devices based on the client input.
    This way, the client does not need to know the exact type of the device, but only the common interface.

```java
public class SmartDeviceFactory {
    public ISmartDevice getSmartDevice(String deviceType) {
        if (deviceType == null) {
            return null;
        }

        return switch (deviceType) {
            case "LIGHT_BULB" -> new SmartLightBulb();
            case "SECURITY_CAMERA" -> new SmartSecurityCamera();
            case "THERMOSTAT" -> new SmartThermostat();
            default -> null;
        };

    }
}
```

3. Singleton Pattern
The pattern is used to ensure that there is only one instance of the `HomeController` class in the system. This way, all
the rooms in the house can be controlled by the same instance of the `HomeController` class, thus avoiding conflicting
commands from different instances of the class. Also it helps with mantaining a consistent state of the system, in a single
point of control.

```java
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
```

## Conclusions

In conclusion, this laboratory work helped me understand the Creational Design Patterns and how they can be used in a real
case scenario to improve the code quality and maintainability. Even though now I have created the system with the need
to use these patterns, I can see how they can be useful in the future for other projects, either in a work environment or
in personal projects. To summarize the knowledge gained from this laboratory work, I can say that the Creational Design 
Patterns are a useful and powerful tool in the software development process, that can help developers create better and
more maintainable code, through a clear separation of concerns and a clear way of creating objects that enables the 
client to use them without knowing the exact implementation details.