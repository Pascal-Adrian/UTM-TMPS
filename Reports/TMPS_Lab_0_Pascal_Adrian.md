# Laboratory Work No.0 - Solid Principles

---

## Pascal Adrian, FAF-221

---

### Objectives
1. Study and understand the SOLID principles;
2. Implement 2 of the SOLID principles in a project.
3. Write a report.

---

### Introduction
The SOLID principles are a set of 5 principles that help developers design maintainable and scalable applications. 
These principles were introduced by Robert C. Martin in his 2000 paper "Design Principles and Design Patterns". 
The SOLID acronym stands for:

- **S**ingle Responsibility Principle
- **O**pen/Closed Principle
- **L**iskov Substitution Principle
- **I**nterface Segregation Principle
- **D**ependency Inversion Principle

---

### Chosen Principles

1. **Interface Segregation Principle** - 
A client should never be forced to implement an interface that it doesn't use or clients shouldn't be forced to depend 
on methods they do not use. This principle is about breaking up interfaces that are very large into smaller and more 
specific ones so that clients will only have to know about the methods that are of interest to them. 


2. **Open/Closed Principle** -
Objects or entities should be open for extension but closed for modification. This means that a class should be
extendable without modifying the class itself. In doing so, we stop ourselves from modifying existing code and causing
potential new bugs

---

### Implementation
#### Open/Closed Principle

To showcase the Open/Close Principle, I created a simple example of a `NotificationService` class that uses
a switch statement to determine the type of notification to send. The problem with this approach is that if we want to
add a new type of notification, we would have to modify the `sendNotification` method. This violates the Open/Close Principle
because the `NotificationService` class is not closed for modification.

```python
class NotificationServiceWrong:
    def send(self, message, method):
        if method == 'email':
            self.__send_email(message)
        elif method == 'sms':
            self.__send_sms(message)
        else:
            raise ValueError('Invalid method')

    def __send_email(self, message):
        print('Sending email:', message)

    def __send_sms(self, message):
        print('Sending SMS:', message)
```

To fix this, I created a abstract class called `NotificationService` that just defines the `send` method. Then, I
created two separate classes, `EmailNotificationService` and `SmsNotificationService`, that implement the `send` method.
This way, if we want to add a new type of notification, we can just create a new class that implements the `send` method
without modifying the existing code.

```python
class NotificationService(ABC):
    @abstractmethod
    def send(self, message):
        raise NotImplementedError


class EmailNotificationService(NotificationService):
    def send(self, message):
        print('Sending email:', message)


class SMSNotificationService(NotificationService):
    def send(self, message):
        print('Sending SMS:', message)
```

#### Interface Segregation Principle

To display the Interface Segregation Principle, I created a simple example a `IMultifunctionalPrinter` interface that
defines 3 methods: `print`, `scan`, and `fax`. Then, I created a `SimplePrinter` class that implements the `print` method
and does not implement the `scan` and `fax` methods. This violates the Interface Segregation Principle because the
`SimplePrinter` class is forced to implement methods that it does not use. 

```python
class IMultiFunctionPrinterWrong:
    def print(self, document):
        pass

    def scan(self, document):
        pass

    def fax(self, document):
        pass


class SimplePrinterWrong(IMultiFunctionPrinterWrong):
    def print(self, document):
        print(f"Printing: {document}")

    # Unnecessary methods for this class
    def scan(self, document):
        raise NotImplementedError("SimplePrinter can't scan")

    def fax(self, document):
        raise NotImplementedError("SimplePrinter can't fax")


# Concrete implementation for an advanced printer
class AdvancedPrinterWrong(IMultiFunctionPrinterWrong):
    def print(self, document):
        print(f"Printing: {document}")

    def scan(self, document):
        print(f"Scanning: {document}")

    def fax(self, document):
        print(f"Faxing: {document}")
```


To fix this, I created 3 separate interfaces,
`IPrinter`, `IScanner`, and `IFax`, that define the `print`, `scan`, and `fax` methods respectively. Then, I created a
`SimplePrinter` class that implements the `IPrinter` interface and a `MultifunctionalPrinter` class that implements all 3
interfaces.

```python
class IPrinter:
    def print(self, document):
        pass

class IScanner:
    def scan(self, document):
        pass

class IFax:
    def fax(self, document):
        pass


class SimplePrinter(IPrinter):
    def print(self, document):
        print(f"Printing: {document}")


class AdvancedPrinter(IPrinter, IScanner, IFax):
    def print(self, document):
        print(f"Printing: {document}")

    def scan(self, document):
        print(f"Scanning: {document}")

    def fax(self, document):
        print(f"Faxing: {document}")
```

---

### Conclusion

**Open/Closed Principle** - this principle is important because it helps prevent potential bugs when adding new features to an
application. Also, it makes versioning easier because we can just create a new class that implements the new feature
without modifying the existing code.

**Interface Segregation Principle** - this principle is important because it helps prevent potential bugs when implementing
multiple related classes, that share common functionality, but are not fully interchangeable. By breaking up large
interfaces into smaller and more specific ones, we can create more specialized classes that only implement the methods
that are of interest to them, thus optimizing the use of memory and resources.

The SOLID principles are a set of guidelines that help developers design maintainable and scalable applications. 
Even though they seem to create more work upfront, they help prevent potential bugs and make the code easier to maintain
in the long run. By following these principles, developers can create more flexible and robust applications that are
easier to extend and maintain. 


