package Domain.Classes;

import Domain.Interfaces.ISubscribable;
import Domain.Interfaces.ISmartLock;
import Domain.Interfaces.ISubscriber;

import java.util.List;

public class SmartLock implements ISmartLock, ISubscribable {
    private boolean state;
    private boolean connectionState;
    private boolean isLocked;
    private String pin;
    private List<ISubscriber> subscribers;

    public SmartLock(String pin) {
        this.state = false;
        this.connectionState = false;
        this.isLocked = false;
        this.pin = pin;
    }

    @Override
    public void lock() {
        this.isLocked = true;
        notifySubscribers("Smart lock is locked");
    }

    @Override
    public void unlock(String pin) {
        if (this.pin.equals(pin)) {
            this.isLocked = false;
        }
        notifySubscribers("Smart lock is unlocked");
    }

    @Override
    public void changePin(String pin) {
        this.pin = pin;
        notifySubscribers("Smart lock pin is changed");
    }

    @Override
    public boolean getState() {
        return this.state;
    }

    @Override
    public boolean getConnectionState() {
        return this.connectionState;
    }

    @Override
    public void on() {
        this.state = true;
        notifySubscribers("Smart lock is on");
    }

    @Override
    public void off() {
        this.state = false;
        notifySubscribers("Smart lock is off");
    }

    @Override
    public void connect() {
        this.connectionState = true;
        notifySubscribers("Smart lock is connected");
    }

    @Override
    public void disconnect() {
        this.connectionState = false;
        notifySubscribers("Smart lock is disconnected");
    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String message) {
        for (ISubscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }
}
