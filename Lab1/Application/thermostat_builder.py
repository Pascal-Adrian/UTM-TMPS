from Lab1.Application.Interfaces.i_thermostat_builder import IThermostatBuilder
from Lab1.Domain.smart_thermostat import SmartThermostat


class ThermostatBuilder(IThermostatBuilder):
    def __init__(self):
        self.__thermostat = SmartThermostat()

    def with_temperature_unit(self, temperature_unit):
        self.__thermostat.set_temperature_unit(temperature_unit)
        return self

    def with_name(self, name):
        self.__thermostat.set_name(name)
        return self

    def with_room(self, room):
        self.__thermostat.set_room(room)
        return self

    def build(self):
        return self.__thermostat

    def reset(self):
        self.__thermostat = SmartThermostat()
        return self
