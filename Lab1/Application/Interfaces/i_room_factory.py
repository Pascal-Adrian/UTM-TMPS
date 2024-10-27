from abc import ABC, abstractmethod


class IRoomFactory(ABC):
    @abstractmethod
    def create_thermostat(self):
        pass

    @abstractmethod
    def create_light(self):
        pass