from Lab1.Application.thermostat_builder import ThermostatBuilder
from Lab1.Application.light_builder import LightBuilder


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
