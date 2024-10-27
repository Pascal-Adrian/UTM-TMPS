from Lab1.Domain.i_smart_device import ISmartDevice


class SmartLight(ISmartDevice):
    def __init__(self, name=None, room=None):
        self.__type = "light"
        self.__room = room
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

    def get_room(self):
        return self.__room

    def set_room(self, room):
        self.__room = room

    def set_name(self, name):
        self.__name = name

    def get_name(self):
        return self.__name

    def get_type(self):
        return self.__type
