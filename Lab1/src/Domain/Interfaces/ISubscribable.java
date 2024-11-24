package Domain.Interfaces;

public interface ISubscribable {
    void addSubscriber(ISubscriber subscriber);
    void removeSubscriber(ISubscriber subscriber);
    void notifySubscribers(String message);
}
