from Lab1.Application.Interfaces.i_light_builder import ILightBuilder
from Lab1.Domain.smart_light import SmartLight


class LightBuilder(ILightBuilder):
    def __init__(self):
        self.__light = SmartLight()

    def with_name(self, name):
        self.__light.set_name(name)
        return self

    def with_room(self, room):
        self.__light.set_room(room)
        return self

    def build(self):
        return self.__light

    def reset(self):
        self.__light = None
        return self
