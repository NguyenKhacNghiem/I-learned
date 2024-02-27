from Employee import Employee

class Tester(Employee):
    def __init__(self, name, address, base_salary, age, gender, exp_year, type):
        super().__init__(name, address, base_salary, age, gender, exp_year)
        self.type = type
    
    def __str__(self):
        return f"""Tester[
            name: {self.name},
            address: {self.address},
            base_salary: {self.base_salary},
            age: {self.age},
            gender: {self.gender},
            exp_year: {self.exp_year},
            type: {self.type},
        ]"""

    def calculateSalary(self):
        return self.base_salary + 300000*self.exp_year