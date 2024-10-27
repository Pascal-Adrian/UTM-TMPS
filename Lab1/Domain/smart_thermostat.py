from Lab1.Domain.i_smart_device import ISmartDevice


class SmartThermostat(ISmartDevice):
    def __init__(self, name=None, temperature_unit=None, room=None):
        self.__type = "thermostat"
        self.__name = name
        self.__temperature = 20
        self.__temperature_unit = temperature_unit
        self.__status = "OFF"
        self.__room = room
        self.__state = False
        self.__connected = False

    def turn_on(self):
        self.__state = True

    def turn_off(self):
        self.__state = False

    def is_on(self):
        return self.__state

    def set_temperature_unit(self, temperature_unit):
        if temperature_unit not in ["C", "F"]:
            raise ValueError("Invalid temperature unit")
        self.__temperature_unit = temperature_unit

    def get_temperature(self):
        return self.__temperature

    def update_temperature(self, temperature):
        self.__temperature = temperature

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

    def connect(self):
        print(f"{self.__name} connecting...")
        self.__connected = True
        print(f"{self.__name} connected")

    def disconnect(self):
        print(f"{self.__name} disconnecting...")
        self.__connected = False
        print(f"{self.__name} disconnected")