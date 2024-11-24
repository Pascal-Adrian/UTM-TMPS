# Behavioral Design Patterns


## Author: Pascal Adrian FAF-221

----

## Objectives:

1. Study and understand the Behavioral Design Patterns.

2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.

3. Implement some additional functionalities using behavioral design patterns.

## Domain: **Smart Home Controller**

For this project I have chosen to implement a fictional Smart Home Controller, because it is a very wide domain
and can be easily extended with new features, thus making it a good candidate for demonstrating the use of
Design Patterns. For this laboratory work, I had to implement a Behavioral Design Pattern in the system, so I chose
to implement the Observer Pattern. The features implemented are the following:

- **ISubscribable** interface, which is implemented by all objects that can be observed in the system, in this case the `SmartLock` class;
- **ISubscriber** interface, which is implemented by all objects that can observe other objects in the system, in this case the `User` class;

## Used Design Patterns:

1. **Observer Pattern**

    A **behavioral** design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

    ![Observer Pattern Diagram](https://refactoring.guru/images/patterns/diagrams/observer/structure.png)

## Implementation

Given my domain, I have implemented the **Observer** pattern to allow the `User` objects to observe the `SmartLock` objects in the system. 
This pattern ensures that the `User` objects are notified when the `SmartLock` objects change their state, 
thus providing a way to react to these changes. This simulates a real-life scenario where a user would want to be 
notified when the lock on their door is opened or closed. The pattern ensures a consistent and efficient way of communication
between the objects, and provides a way to notify only the interested parties about the changes.

```java
public interface ISubscribable {
    void addSubscriber(ISubscriber subscriber);
    void removeSubscriber(ISubscriber subscriber);
    void notifySubscribers(String message);
}

```

```java
public interface ISubscriber {
    void update(String message);
}
```

```java
public class SmartLock implements ISmartLock, ISubscribable {
    private List<ISubscriber> subscribers;

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
```

## Conclusions

In conclusion, this laboratory work helped me understand the **Behavioural Design Patterns** and how they can be used in a real
case scenario. Even though I have only implemented the Observer Pattern, given that it fits very well with the Smart Home Controller
domain, I have also studied the other **behavioral** patterns and I can see how they can be used in different scenarios.
Studying and implementing these patterns has helped me create a good foundation for using in my future projects, personal or professional.
To summarize everything done and read, I can say that the **Behavioral Design Patterns** are a very important part of the software design
allowing for a predictable and maintainable codebase, and helping with the behavior, communications and interactions between objects in 
complex systems. This is realized by providing clear and efficient templates for correct and efficient assignment of responsibilities
between different parts of the system.