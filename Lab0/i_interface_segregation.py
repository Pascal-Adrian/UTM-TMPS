# Description: Interface Segregation Principle example

# wrong implementation of the interface segregation principle
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


# correct implementation of the interface segregation principle
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


