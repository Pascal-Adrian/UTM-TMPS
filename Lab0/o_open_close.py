from abc import ABC, abstractmethod

# Description: Open-Close Principle

# wrong implementation
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


# correct implementation
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

