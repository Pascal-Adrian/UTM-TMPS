# Creational Design Patterns

----

## Author: Pascal Adrian

----

## Objectives:
__1. Study and understand the Creational Design Patterns.__

__2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

__3. Use some creational design patterns for object instantiation in a sample project.__

----

## Used Creational Design Patterns:

__1. Singleton__

__2. Builder__

__3. Factory__

----

## Implementation:
To showcase the Creational Design Patterns, I have chosen the domain of a smart home system. The smart home system 
consists of the following main classes: ```ISmartDevice``` and ```HouseManager```.


### 1. Singleton

The Singleton pattern is used to ensure that only one instance of a class is created and provide a global point of 
access to the object. In the smart home system, the ```HouseManager``` class is implemented as a Singleton. It is
responsible for managing the smart devices in the house and does not allow multiple instances of the class to be created,
ensuring consistency in the state of the smart devices.

To ensure in ```python``` that the ```HouseManager``` class is a Singleton, the ```__new__``` method is overridden to
check if an instance of the class already exists. If an instance exists, the existing instance is returned, otherwise a
new instance is created.

```python
class HouseManager:
    __instance = None

    def __new__(cls):
        if cls.__instance is None:
            cls.__instance = super(HouseManager, cls).__new__(cls)
            cls.__instance.__smart_devices = []
        return cls.__instance
```

### 2. Builder

The Builder pattern is used to construct complex objects step by step. In the smart home system, the Builder pattern is
used to create instances of the ```SmartThermostat``` and ```SmartLight``` classes. The ```SmartThermostatBuilder``` and
```SmartLightBuilder``` classes are responsible for constructing instances of the respective classes and implement the
```IThermostatBuilder``` and ```ILightBuilder``` interfaces. This allows the client code to create instances of the 
classes with different configurations without exposing their internal details.

```python
class IThermostatBuilder(ABC):
    @abstractmethod
    def with_temperature_unit(self, temperature_unit):
        pass

    @abstractmethod
    def with_name(self, name):
        pass

    @abstractmethod
    def with_room(self, room):
        pass
```

```python
class ILightBuilder(ABC):
    @abstractmethod
    def with_name(self, name):
        pass

    @abstractmethod
    def with_room(self, room):
        pass

    @abstractmethod
    def build(self):
        pass

    @abstractmethod
    def reset(self):
        pass
```


### 3. Factory

The Factory pattern is used to create objects without specifying the exact class of object that will be created. In the
smart home system, the Factory pattern is used to create instances of the ```SmartLight``` and ```SmartThermostat``` 
classes based on the room they are installed in. The ```IRoomFactory``` interface defines the method for creating
instances of the smart devices, and the ```LivingRoomFactory``` class implements this interface to create instances 
for the living room.

```python
class LivingRoomFactory:
    def __init__(self):
        self.__thermostat_builder = ThermostatBuilder()
        self.__light_builder = LightBuilder()

    def create_thermostat(self):
        return (self.__thermostat_builder
                .with_temperature_unit('C')
                .with_name('Living Room Thermostat')
                .with_room('Living Room')
                .build())

    def create_light(self):
        return (self.__light_builder
                .with_name('Living Room Light')
                .with_room('Living Room')
                .build())
```

----

## Conclusion:
The Creational Design Patterns provide a way to create objects in a flexible and reusable manner. By using these patterns,
we segregate the object creation logic from the client code, making it easier to manage and maintain the codebase. 
Singleton ensures that only one instance of a class is created, giving global access to the object. Builder allows
complex objects to be constructed step by step, simplifying the creation process. Factory provides a way to create
objects without specifying anything about the class or constructor, making the code more flexible and extensible.
In my smart home system example, I have used these patterns to showcase their benefits and demonstrate how they can be
applied in a real-world scenario. By using these patterns, the code becomes easier to understand and more modular, thus
making it more maintainable and scalable. 