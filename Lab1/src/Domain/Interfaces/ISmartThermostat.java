package Domain.Interfaces;

public interface ISmartThermostat extends ISmartDevice {
    void setTemperature(int temperature);
    int getTemperature();
}
