from Lab1.Domain.smart_device import SmartDevice

class SmartLight(SmartDevice):
    def __init__(self, name):
        self.__name = name
        self.__state = False
        self.__connected = False

    def turn_on(self):
        self.__state = True

    def turn_off(self):
        self.__state = False

    def is_on(self):
        return self.__state

    def connect(self):
        print(f"{self.__name} connecting...")
        self.__connected = True
        print(f"{self.__name} connected")

    def disconnect(self):
        print(f"{self.__name} disconnecting...")
        self.__connected = False
        print(f"{self.__name} disconnected")