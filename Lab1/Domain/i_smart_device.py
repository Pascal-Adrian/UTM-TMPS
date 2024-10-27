from abc import ABC, abstractmethod

class ISmartDevice(ABC):
    @abstractmethod
    def turn_on(self):
        pass

    @abstractmethod
    def turn_off(self):
        pass

    @abstractmethod
    def is_on(self):
        pass

    @abstractmethod
    def connect(self):
        pass

    @abstractmethod
    def disconnect(self):
        pass

    @abstractmethod
    def get_room(self):
        pass

    @abstractmethod
    def set_room(self, room: str):
        pass

    @abstractmethod
    def set_name(self, name: str):
        pass

    @abstractmethod
    def get_name(self):
        pass

    @abstractmethod
    def get_type(self):
        pass
