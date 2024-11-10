package Domain.Interfaces;

public interface ISmartDevice {
    boolean getState();
    boolean getConnectionState();
    void on();
    void off();
    void connect();
    void disconnect();
}
