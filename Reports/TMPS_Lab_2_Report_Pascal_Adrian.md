# Structural Design Patterns


## Author: Pascal Adrian FAF-221

----

## Objectives:

1. Study and understand the Structural Design Patterns.__

2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.__

3. Implement some additional functionalities using structural design patterns.__

## Domain: **Smart Home Controller**

For this project I have chosen to implement a fictional Smart Home Controller, because it is a very wide domain
and it can be easily extended with new features, thus making it a good candidate for demonstrating the use of
Design Patterns. For this laboratory work, I had to implement 3 Structural Design Patterns: Adapter, Decorator and Facade.
The features that implement these patterns are the following:

- **RGBtoHSLSmartLightBulbAdapter** class, which is used to adapt the `IHSLSmartLightBulb` interface to the 
    `IRGBSmartLightBulb` interface by accepting `RGB` color values and converting them to `HSL` color values then 
    passing them to the objects that implement the `IHSLSmartLightBulb` interface.

- **SmartSecurityCameraLightDecorator** class, which is used to add light control functionality to the `ISmartSecurityCamera` 
    objects adding the logic to turn on and off the light when the camera is turned on and off.

- **HouseController** class, which is used to provide a simple interface for the client to control the devices and
    rooms in the house without knowing the exact implementation details of the devices and rooms. It acts as a facade
    for the whole system.

## Used Design Patterns:

1. **Adapter Pattern**

    Adapter is a **structural*** design pattern that allows objects with incompatible interfaces to collaborate.
    ![Adapter Pattern Diagram](https://refactoring.guru/images/patterns/diagrams/adapter/structure-class-adapter.png)

2. **Decorator Pattern**

    Decorator is a **structural** design pattern that lets you attach new behaviors to objects by placing these objects 
    inside special wrapper objects that contain the behaviors.
    ![Decorator Pattern Diagram](https://refactoring.guru/images/patterns/diagrams/decorator/structure.png?id=8c95d894aecce5315cc1b12093a7ea0c)

3. **Facade Pattern**

    Facade is a **structural** design pattern that provides a simplified interface to a library, a framework, or any other 
    complex set of classes.
    ![Facade Pattern Diagram](https://refactoring.guru/images/patterns/diagrams/facade/structure-2x.png)

## Implementation

Given the domain, I have implemented the **Adapter**, **Decorator** and **Facade** patterns to add new functionalities to the
system in a simpler and more organized way. These patterns ensure code maintainability and scalability, by simplifying the
interaction between the objects in the system and the interaction between the client and the system.

1. Adapter Pattern

    The pattern is used to adapt the `IHSLSmartLightBulb` interface to the `IRGBSmartLightBulb` interface by accepting `RGB` color
    values and converting them to `HSL` color values then passing them to the objects that implement the `IHSLSmartLightBulb` interface.
    The `RGBtoHSLSmartLightBulbAdapter` class is used to adapt the `IHSLSmartLightBulb` interface to the `IRGBSmartLightBulb` interface, 
    so that all the objects that implement the `IHSLSmartLightBulb` interface can be used as `IRGBSmartLightBulb` objects,
    maintaining consistency in the system.

```java
public class RGBtoHSLSmartLightBulbAdapter implements IRGBSmartLightBulb {
    private IHSLSmartLightBulb bulb;

    public RGBtoHSLSmartLightBulbAdapter(IHSLSmartLightBulb bulb) {
        this.bulb = bulb;
    }

    @Override
    public void setColor(int red, int green, int blue) {
        int[] hsl = convertRGBtoHSL(red, green, blue);
        bulb.setColor(hsl[0], hsl[1], hsl[2]);
    }

    @Override
    public int[] getColor() {
        return bulb.getColor();
    }

    private int[] convertRGBtoHSL(int red, int green, int blue) {
        int r = red / 255;
        int g = green / 255;
        int b = blue / 255;

        int max = Math.max(r, Math.max(g, b));
        int min = Math.min(r, Math.min(g, b));
        int h = 0;
        int s = 0;
        int l = (max + min) / 2;

        if (max == min) {
            h = s = 0;
        } else {
            int d = max - min;
            s = l > 0.5 ? d / (2 - max - min) : d / (max + min);
            if (max == r) {
                h = (g - b) / d + (g < b ? 6 : 0);
            } else if (max == g) {
                h = (b - r) / d + 2;
            } else if (max == b) {
                h = (r - g) / d + 4;
            }
            h /= 6;
        }

        return new int[] {h, s, l};
    }

    @Override
    public void on() {
        bulb.on();
    }

    @Override
    public void off() {
        bulb.off();
    }

    @Override
    public void connect() {
        bulb.connect();
    }

    @Override
    public void disconnect() {
        bulb.disconnect();
    }

    @Override
    public boolean getState() {
        return bulb.getState();
    }

    @Override
    public boolean getConnectionState() {
        return bulb.getConnectionState();
    }

    @Override
    public void setBrightness(int brightness) {
        bulb.setBrightness(brightness);
    }

    @Override
    public int getBrightness() {
        return bulb.getBrightness();
    }
}
```

2. Decorator Pattern

    The pattern is used to add light control functionality to the `ISmartSecurityCamera` objects by adding it through the
    `SmartSecurityCameraLightDecorator` class. This class implements the `ISmartSecurityCamera` interface and adds the
    functionality to turn on and off the light when the camera is turned on and off. This way, the light control functionality
    can be added to any `ISmartSecurityCamera` object without modifying the existing code.

```java
package Application.Decorators;

import Domain.Interfaces.ISmartSecurityCamera;

import java.time.LocalTime;

public class SmartSecurityCameraLightDecorator implements ISmartSecurityCamera {
    private ISmartSecurityCamera camera;
    private boolean lightState;

    public SmartSecurityCameraLightDecorator(ISmartSecurityCamera camera) {
        this.camera = camera;
    }

    @Override
    public void on() {
        this.handleLight();
        camera.on();
    }

    @Override
    public void off() {
        this.turnLightOff();
        camera.off();
    }

    @Override
    public void connect() {
        camera.connect();
    }

    @Override
    public void disconnect() {
        camera.disconnect();
    }

    @Override
    public boolean getState() {
        return camera.getState();
    }

    @Override
    public boolean getConnectionState() {
        return camera.getConnectionState();
    }

    @Override
    public int getResolution() {
        return camera.getResolution();
    }

    private void turnLightOn() {
        lightState = true;
        System.out.println("Turning on security camera light...");
    }

    private void turnLightOff() {
        lightState = false;
        System.out.println("Turning off security camera light...");
    }

    private void handleLight() {
        LocalTime time = LocalTime.now();
        if (time.isAfter(LocalTime.of(18, 0)) || time.isBefore(LocalTime.of(6, 0))) {
            turnLightOn();
        } else {
            turnLightOff();
        }
    }
}
```

3. Facade Pattern
    
    The pattern is used to provide a simple interface for the client to control the devices and rooms in the house without
    knowing the exact implementation details of the devices and rooms. The `HouseController` class acts as a facade for the
    whole system, providing a simple interface for the client to interact with the system. The client can control the devices
    and rooms in the house by using the `HouseController` class and its methods by passing the information to the 
    `HouseController`, which then delegates the work to the appropriate objects in the system.

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
```

## Conclusions

In conclusion, this laboratory work helped me understand the Structural Design Patterns and how they can be used in a real
case scenario to improve the code quality and maintainability. Even though now I have adapted the system to use this patterns,
I can see how they can be useful in the future for other projects, either in a work environment or in personal projects.
To summarize the knowledge gained from this laboratory work, I can say that the Structural Design Patterns are a great way
of dealing with complex systems, by providing a way to simplify the interaction between the objects and the client, thus
making them easier to understand and maintain. This is realized by providing flexible and efficient structures that can 
be easily extended and modified to accommodate new features and functionalities or integrate with other systems.