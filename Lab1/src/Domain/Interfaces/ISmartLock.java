package Domain.Interfaces;

public interface ISmartLock extends ISmartDevice{
    void lock();
    void unlock(String pin);
    void changePin(String pin);
}
