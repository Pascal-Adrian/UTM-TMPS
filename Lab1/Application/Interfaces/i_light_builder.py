from abc import ABC, abstractmethod


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
