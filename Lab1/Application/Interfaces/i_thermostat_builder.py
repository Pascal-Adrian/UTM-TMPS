from abc import ABC, abstractmethod


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

    @abstractmethod
    def build(self):
        pass

    @abstractmethod
    def reset(self):
        pass
