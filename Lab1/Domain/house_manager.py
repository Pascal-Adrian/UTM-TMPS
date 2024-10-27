class HouseManager:
    __instance = None

    def __new__(cls):
        if cls.__instance is None:
            cls.__instance = super(HouseManager, cls).__new__(cls)
            cls.__instance.__smart_devices = []
        return cls.__instance

    def add_smart_device(self, smart_device):
        self.__smart_devices.append(smart_device)

    def remove_smart_device(self, smart_device):
        self.__smart_devices.remove(smart_device)

    def lights_on(self, room="all"):
        for smart_device in self.__smart_devices:
            if smart_device.get_type() == "light":
                if smart_device.get_room() == room:
                    smart_device.turn_on()
                elif room == "all":
                    smart_device.turn_on()

    def lights_off(self, room="all"):
        for smart_device in self.__smart_devices:
            if smart_device.get_type() == "light":
                if smart_device.get_room() == room:
                    smart_device.turn_off()
                elif room == "all":
                    smart_device.turn_off()

