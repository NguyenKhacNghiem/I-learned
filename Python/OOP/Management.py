from Developer import Developer
from Tester import Tester

class Management:
    def __init__(self):
        self.employees = []

        self.employees.append(Developer("Peter", "Hanoi", 10000000, 28, "Male", 5, "Java"))
        self.employees.append(Tester("Anna", "Ho Chi Minh city", 8000000, 26, "Female", 2, "Manual Test"))
    
    def showInfo(self):
        for e in self.employees:
            print(e)

    def showSalary(self):
        for e in self.employees:
            print("Developer's ", end="") if isinstance(e, Developer) else print("Tester's ", end="")  
            print("salary:", e.calculateSalary())